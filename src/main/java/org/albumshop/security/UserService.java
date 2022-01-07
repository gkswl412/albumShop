package org.albumshop.security;


import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.albumshop.domain.User;
import org.albumshop.persistence.CartRepository;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




@Service
public class UserService implements UserDetailsService{
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	PasswordEncoder passwordEncoder; // security config에서 Bean생성
	
	@Autowired
	CartRepository cartRepository; // 회원가입 시 자동으로 Cart 생성


	// 회원가입
	@Transactional
	public User joinUser(User user) {
		// 비밀번호 암호화...암호화되지않으면 로그인되지않는다.
		      String pass = passwordEncoder.encode(user.getPass());
		      user.setPass(pass);
			  //cartRepository.save(user);
		System.out.println("암호화된 pass:" + pass);

		return urepo.save(user);
	}

	//반드시 구현해야한다. 
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername id:" + id);
		//filter는 조건에 맞는것만 선택
		//map: 변형한다. 
		org.albumshop.domain.User user = urepo.findById(id).orElse(null);
		UserDetails user2 = urepo.findById(id)
				.filter(m -> m != null).map(m -> new SecurityUser(m)).get();
		System.out.println("user:" + user);
		httpSession.setAttribute("user2", user2);
		httpSession.setAttribute("user", user);
		return user2;
	}
	
	
	
	
}
 