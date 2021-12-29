package org.albumshop.controller;

import java.util.Map;

import javax.transaction.Transactional;

import org.albumshop.domain.Album;
import org.albumshop.domain.Review;
import org.albumshop.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review/*")
public class ReviewRestController {
	
	@Autowired
	private ReviewService reviewService;
	
	//리뷰 리스트 요청
	@GetMapping("/{albumId}")
	public ResponseEntity<Map<String, Object>> getReviewList(@PathVariable("albumId") Long albumId) {
		Map<String, Object> output = reviewService.getReviewListByAlbum(Album.builder().id(albumId).build());
		return new ResponseEntity<>(output, HttpStatus.CREATED);
	}
	
	//리뷰 등록 요청
	@Transactional
	@PostMapping("/{albumId}")
	public ResponseEntity<Map<String, Object>> createReview(@PathVariable("albumId") Long albumId, @RequestBody Review review){
		System.out.println(review);
		reviewService.createReview(review);
		Map<String, Object> output = reviewService.getReviewListByAlbum(Album.builder().id(albumId).build());
		return new ResponseEntity<>(output, HttpStatus.CREATED);
	}
	
	//리뷰 삭제 요청
	@Transactional
	@DeleteMapping("/{albumId}/{userId}")
	public ResponseEntity<Map<String, Object>> deleteReview(@PathVariable("albumId") Long albumId, @PathVariable("userId") String userId){
		
		reviewService.deleteReview(albumId, userId);
		Map<String, Object> output = reviewService.getReviewListByAlbum(Album.builder().id(albumId).build());
		
		return new ResponseEntity<>(output, HttpStatus.OK);
	}
	
	//리뷰 수정 요청
	@Transactional
	@PutMapping("/{albumId}")
	public ResponseEntity<Map<String, Object>> updateReview(@PathVariable("albumId") Long albumId, @RequestBody Review review){
		
		reviewService.updateReview(review);
		Map<String, Object> output = reviewService.getReviewListByAlbum(Album.builder().id(albumId).build());
		
		return new ResponseEntity<>(output, HttpStatus.CREATED);
	}
	
	//좋아요 싫어요 수정 요청
	@Transactional
	@PostMapping("/thumb/{userId}/{albumId}/{job}")
	public Map<String,Object> createEmpathy(
			@PathVariable("userId") String userId,
			@PathVariable("albumId") Long albumId,
			@PathVariable("job") String job){
		return reviewService.checkEmpathyTable(userId, albumId, job);
	}
	
	
}
