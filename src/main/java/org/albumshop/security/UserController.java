/*
package org.albumshop.security;

import java.util.Optional;

import org.albumshop.domain.User;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {
    
	
	@Autowired
    UserRepository urepo;
	   
	@Autowired
	UserService uservice;
	
	@RequestMapping("/user/main")
	public void hello() {
		
	
		
	}
	
	@RequestMapping(value="/user/login",method = RequestMethod.GET)
	public void login() {
		
		
		
	}
	
	@RequestMapping(value="/user/login",method = RequestMethod.POST)
	public void loginPost() {
		
		
		
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public void logout() {
		
		
		
	}
	
	
	@RequestMapping("/user/loginSuccess")
	public void loginSuccess() {
		
		
		
	}
	
	@GetMapping("/user/join")
	public String join() {
		
		return "/user/joinForm";
		
	}
	
	
	@PostMapping("/user/joinProc")
	public String register(User user) {
		System.out.println("==회원가입하기==");
		uservice.joinUser(user);
		
		return "/user/joinSuccess";
		
	}
	
	
	
	*/
/*@RequestMapping(value = "/IdCheck", method = RequestMethod.POST)
	@ResponseBody
	 public String IdCheck (String id) throws Exception { 
		 
			int result = urepo.findById(id);

			if(result != 0) {
				
				return "fail";	
				
			} else {
				
				return "success";	
				
			}	
	
	 }*//*

}
*/
