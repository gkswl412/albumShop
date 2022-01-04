package org.albumshop.controller;


import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.albumshop.domain.User;
import org.albumshop.persistence.ReviewRepository;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
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
	@GetMapping(value = "/userInfo/MyPage")
	public String MyPage(Model model, String id) {
		User user = (User) session.getAttribute("user");
		model.addAttribute("review", reRepo.findReviewById(user.getId()));
		return "userInfo/Mypage";
	}
	
	@PostMapping("/UserUpdate")
	public String update(Model model, String id, String name, 
			String nickName, String email, String phone, 
			@RequestParam(value = "birth", required=false)@DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate birth, 
			String gender) {
		User user = uRepo.findById(id).get();
		user.setName(name);
		user.setNickName(nickName);
		user.setEmail(email);
		user.setPhone(phone);
		user.setBirth(birth);
		user.setGender(gender);
		uRepo.save(user);
	    session.setAttribute("user", user);
	    model.addAttribute("message","회원 정보가 수정 되었습니다.");
		return "userInfo/MyPage";
	}
	
	@PostMapping("/UserDelete")
	public String delete(Model model, String id) {
		
		
		return "redirect:/albumlist";
	} 
	
	
	@RequestMapping("/userInfo/MyInfoUpdate")
	public String MyInfoUpdate() {
		
		return "/userInfo/MyInfoUpdate";
	}
	
	@GetMapping("/MyCartList")
	public String mycartlist(Model model, String id) {
		model.addAttribute("cartlist", uRepo.findMyCartById(id));
		return "/userInfo/MyCartList";
	}
	@GetMapping("/MyAlbumTitleList")
	public String myalbumTitlelist(Model model, String id) {
		model.addAttribute("albumlist", uRepo.findMyAlbumById(id));
		return "/userInfo/MyAlbumTitleList";
	}
	@GetMapping("/MyAlbumList")
	public String myalbumlist(Model model, String id, String mylisttitle) {
		model.addAttribute("album", uRepo.findMyAlbumListById(id, mylisttitle));
		return "/userInfo/MyAlbumList";
	}
	
	
	
}