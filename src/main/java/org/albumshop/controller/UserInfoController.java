package org.albumshop.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.albumshop.domain.Review;
import org.albumshop.domain.User;
import org.albumshop.persistence.ReviewRepository;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserInfoController {

	@Autowired
	private UserRepository uRepo;
	@Autowired
	private ReviewRepository reRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	
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
	public String updatepass(Model model, String id, String pass) {
		Optional<User> user = uRepo.findById(id);
	    String pass1 = passwordEncoder.encode(pass);
		user.get().setPass(pass1);
		uRepo.save(user.get());
		model.addAttribute("message", "비밀번호 변경에 성공했습니다.");
		return "redirect:/userInfo/userDetail";
	}
	
	
	@GetMapping("/AddressChangeForm")
	public String updateUserAddress(Model model, String id, String job) {
		Optional<User> user = uRepo.findById(id);
		model.addAttribute("userinfo", user.get());
		return "userInfo/AddressChangeForm";
	}
	
	
	@GetMapping(value="userDetail")
	public String UserDetail(Model model, String userid) {
		Optional<User> user = uRepo.findById(userid);
		model.addAttribute("UserInfo", user.get());
		
		model.addAttribute("review", reRepo.findReviewById(userid));
		return "userInfo/userInfo";
	}
	
}
