package org.albumshop.controller;


import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.albumshop.domain.User;
import org.albumshop.persistence.ReviewRepository;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 

@Controller
public class UserInfoController {

	@Value("${spring.servlet.multipart.location}")
	String uploadPath;
	
	@Autowired
	private UserRepository uRepo;
	@Autowired
	private ReviewRepository reRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	HttpSession session;
	
	@PostMapping("/PassWordChangeForm")
	public String updateUserPass(Model model, String id, String pass, String job) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<User> user = uRepo.findById(id);		
		if(encoder.matches(pass, user.get().getPass()) == true) {
			model.addAttribute("user", user.get());
			model.addAttribute("job", job);
			return "userInfo/PassWordChangeForm";
		}else {
			model.addAttribute("message", "다시 확인 바랍니다.");
			return "test";
		}
	}
	
	@PostMapping("/passchange")
	public String updatepass(Model model, String id,RedirectAttributes re_attr, String pass) {
		Optional<User> user = uRepo.findById(id);
	    String pass1 = passwordEncoder.encode(pass);
		user.get().setPass(pass1);
		uRepo.save(user.get());
		re_attr.addFlashAttribute("message1", "비밀번호 변경에 성공했습니다.");
		return "redirect:/userInfo/MyInfoUpdate";
	}
	
	
	@GetMapping("/AddressChangeForm")
	public String updateUserAddress(Model model, String id, String job) {
		Optional<User> user = uRepo.findById(id);
		model.addAttribute("userinfo", user.get());
		return "userInfo/AddressChangeForm";
	}
	
	
	@GetMapping(value="userInfo")
	public String UserDetail(Model model, String userid) {
		Optional<User> user = uRepo.findById(userid);
		model.addAttribute("UserInfo", user.get());
		model.addAttribute("review", reRepo.findReviewById(userid));		
		return "userInfo/userInfo";
	}
	
	@PostMapping("/addresschange")
	public String updateAddress(Model model, String id, String addr) {
		System.out.println(addr);
		Optional<User> user = uRepo.findById(id);
		user.get().setAddress(addr);
		uRepo.save(user.get());
		session.setAttribute("user", user.get());
		model.addAttribute("message", "주소 변경에 성공했습니다.");
		return "redirect:/userInfo/MyInfoUpdate";
	}
	
	@PostMapping("/PhotoChangeForm")
	public String updateUserPhoto(Model model, String id, String photo) {
		Optional<User> user = uRepo.findById(id);
		model.addAttribute("userinfo", user.get());
		return "userInfo/PhotoChangeForm";
	}
	
	@RequestMapping("/photochange")
	public String updatePhoto(MultipartFile file, HttpServletRequest req, String id, String photo) {
	     // jsp file name mapping     
		User user = uRepo.findById(id).get();
	    String original = file.getOriginalFilename(); // 업로드하는 파일 name
	    user.setPhoto(original);
	    uRepo.save(user);
	    session.setAttribute("user", user);
	    String fileName = uploadPath + File.separator + original; // 파일 업로드 경로 + 파일 이름
	    try {
	        file.transferTo(new File(fileName)); // 파일을 위에 지정 경로로 업로드
	    } catch (IllegalStateException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return "redirect:/userInfo/MyInfoUpdate";		
	}
	@RequestMapping(value = "/userInfo/MyPage")
	public String MyPage(String id) {
		
		
		return "/userInfo/Mypage";
	}
	@RequestMapping("/userInfo/MyInfoUpdate")
	public String MyInfoUpdate() {
		
		return "/userInfo/MyInfoUpdate";
	}
	
}
