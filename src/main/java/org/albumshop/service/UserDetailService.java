package org.albumshop.service;

import java.util.Optional;

import org.albumshop.domain.User;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {

	@Autowired
	UserRepository uRepo;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Optional<User> userPassCheck(String userid, String pass) {
		Optional<User> user = uRepo.findById(userid);
		String pw = passwordEncoder.encode(pass);
		if(user.get().getPass() == pw) {
			return uRepo.findById(userid);	
		}else {
			return null;	
		}
	}
}
