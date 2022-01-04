package org.albumshop.service;

import javax.servlet.http.HttpSession;

import org.albumshop.domain.MyList;
import org.albumshop.domain.User;
import org.albumshop.persistence.MyListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyListService {
	
	@Autowired
	MyListRepository myListRepo;
	@Autowired
	HttpSession session;
	
	public void makeMyList(String myListTitle) {
		User user = (User) session.getAttribute("user");
		MyList mylist = MyList.builder().myListTitle(myListTitle).user(user).build();
		myListRepo.save(mylist);
	}
	
}
