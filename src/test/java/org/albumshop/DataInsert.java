package org.albumshop;

import org.albumshop.domain.User;
import org.albumshop.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataInsert {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	User user;
	
	@Test
	public void inserUser() {
		for(int i=0;i<10;i++) {
			
		}
	}
}
