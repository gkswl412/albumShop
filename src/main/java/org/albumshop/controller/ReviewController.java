package org.albumshop.controller;

import org.albumshop.domain.Album;
import org.albumshop.domain.Review;
import org.albumshop.domain.User;
import org.albumshop.service.AlbumService;
import org.albumshop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	@Autowired
	AlbumService albumService;
	
	@GetMapping("/writeReviewForm")
	public String getWriteReviewForm(Model model, Long albumId, String userId, String job) {
		System.out.println(job);
		System.out.println(albumId);
		System.out.println(userId);
		User user = reviewService.getUserInfo(userId);
		Album album = Album.builder().id(albumId).build();
		Review review = new Review();
		if(job.equals("update") || job.equals("delete")) {
			review = reviewService.getReviewByUser(user, album);
		}
		model.addAttribute("albumId",albumId);
		model.addAttribute("user",user);
		model.addAttribute("job",job);
		model.addAttribute("review",review);
		return "review/writeReviewForm";
	}
	@GetMapping("/replyForm")
	public String getReplyForm() {
		
		return "review/replyForm";
	}
	@GetMapping("/reply_replyForm")
	public String getReplyReplyForm() {
		
		return "review/reply_replyForm";
	}
}
