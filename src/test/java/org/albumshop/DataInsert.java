package org.albumshop;

import java.time.LocalDate;

import org.albumshop.domain.User;
import org.albumshop.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

@SpringBootTest
public class DataInsert {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	User user;
	
	@Test
	public void inserUser() {
		for(int i=0;i<10;i++) {
			user.setAddress("제주도 서귀포시 " + i);
			LocalDate birthDate = LocalDate.of(199+i, 0+i, 0+i);
			user.setBirth(birthDate);
			user.setEmail("abc" + i + "@kost.com");
			if(i%2==0) {
				user.setGender("남자");
			}else {
				user.setGender("여자");
			}
			if(i==0) {
				user.setGrade("Diamond");
			}else if(i==1 ) {
				user.setGrade("Gold");
			}
		}
	}
}
