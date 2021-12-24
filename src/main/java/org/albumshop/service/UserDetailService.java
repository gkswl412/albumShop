package org.albumshop.service;

import java.util.List;
import java.util.Optional;

import org.albumshop.domain.Delivery;
import org.albumshop.domain.MyList;
import org.albumshop.domain.User;
import org.albumshop.persistence.DeliveryRepository;
import org.albumshop.persistence.MyListRepository;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	MyListRepository myListRepository;

	@Autowired
	DeliveryRepository deliveryRepository;

	public User findByUserId(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}

	public List<MyList> findByMyListId(String id, Pageable pageble) {
		List<MyList> myList = myListRepository.findByUserId(id, pageble);
		return myList;
	}

	public List<Delivery> findDelivertByUserId(String id, Pageable pageble) {
		List<Delivery> delivertList = deliveryRepository.findDelivertByUserId(id, pageble);
		return delivertList;
	}

}
