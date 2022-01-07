package org.albumshop.security;


import java.util.Optional;


import javax.servlet.http.HttpSession;

import org.albumshop.domain.User;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

                      


@Controller
public class UserController {

	@Autowired
	UserRepository urepo;

	@Autowired
	UserService uservice;
	@Autowired
	HttpSession session;

	@Autowired
	SendEmailService sservice;

	@RequestMapping("/user/main")
	public void hello() {

	}

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public void login() {

	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public void loginPost() {

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout() {

	}

	@GetMapping("/user/join")
	public String join() {

		return "/user/joinForm";

	}

	@PostMapping("/user/joinProc")
	public String register(User user) {
		System.out.println("==회원가입하기==");
		uservice.joinUser(user);

		return "redirect:/user/login";

	}

	@RequestMapping(value = "/user/IdCheck", method = RequestMethod.POST)
	@ResponseBody
	public String IdCheck(String id) throws Exception {
		// System.out.println(id);
		User user = urepo.findById(id).orElse(null);
		// System.out.println(user);
		if (user != null) {

			return "fail";

		} else {

			return "success";

		}

	}

	@RequestMapping(value = "/user/nickCheck", method = RequestMethod.POST)
	@ResponseBody
	public String nickCheck(String nickName) throws Exception {
		// System.out.println(nickName);
		User user = urepo.findByNickName(nickName).orElse(null);
		// System.out.println(user);
		if (user != null) {

			return "fail";

		} else {

			return "success";

		}

	}

	@RequestMapping(value = "/user/emailCheck", method = RequestMethod.POST)
	@ResponseBody
	public String emailCheck(String email) throws Exception {

		User user = urepo.findByEmail(email).orElse(null);
		if (user != null) {

			return "fail";

		} else {

			return "success";

		}

	}

	@RequestMapping(value = "/findid", method = RequestMethod.POST)
	@ResponseBody
	public String findid(String name, String email) {

		Optional<User> user = urepo.findByNameAndEmail(name, email);
		if (user.isEmpty()) {
			return "입력하신 정보로 가입 된 회원 아이디는 존재하지 않습니다.";
		} else {
			return "아이디 찾기가 완료했습니다.\n\n회원의 아이디: " + user.get().getId();
		}

	}

	@RequestMapping(value = "/findpw", method = RequestMethod.POST)
	@ResponseBody
	public String findpw(String id, String email) throws Exception {
		int result = sservice.updatePw(id, email);
		if (result == 0) {
			return "입력하신 정보로 가입 된 회원 아이디 또는 이메일는 존재하지 않습니다.";

		} else {
			return "임시 비밀번호를 해당 메일에 발송하였습니다.";

		}

	}

}