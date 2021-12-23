package org.albumshop.controller;

import org.albumshop.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserInfoController {

	@Autowired
	UserDetailService userDetailService;

	// 개인정보
	@GetMapping("/userdetail/{userId}")
	public String userDetail(@PathVariable("userId") String userId, Model model) {
		model.addAttribute("userDedatil", userDetailService.findByUserId(userId));
		return "userDetail";
	}

	// 마이리스트
	@GetMapping("/userMyListDetail/{userId}")
	public String userMyListDetail(@PathVariable("userId") String userId, Model model, Pageable pageble) {
		model.addAttribute("myListList", userDetailService.findByMyListId(userId, pageble));
		return "userMyListDetail";
	}

	// 주문내역
	@GetMapping("/userMyListDetail/{userId}")
	public String userDeliveryList(@PathVariable("userId") String userId, Model model, Pageable pageble) {
		model.addAttribute("myListList", userDetailService.findDelivertByUserId(userId, pageble));
		return "userDeliveryList";
	}

}
