package org.albumshop.controller;

import java.util.List;

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

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/review/*")
@Slf4j
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	//리뷰 리스트 요청
	@GetMapping("/{albumId}")
	public ResponseEntity<List<Review>> getReviewList(@PathVariable("albumId") Long albumId) {
		
		List<Review> reviews = reviewService.getReviewListByAlbum(Album.builder().id(albumId).build());
		
		return new ResponseEntity<>(reviews, HttpStatus.CREATED);
	}
	
	//리뷰 등록 요청
	@Transactional
	@PostMapping("/{albumId}")
	public ResponseEntity<List<Review>> createReview(@PathVariable("albumId") Long albumId, @RequestBody Review review){
		
		reviewService.createReview(review);
		List<Review> reviews = reviewService.getReviewListByAlbum(Album.builder().id(albumId).build());
		
		return new ResponseEntity<>(reviews, HttpStatus.CREATED);
	}
	
	//리뷰 삭제 요청
	@Transactional
	@DeleteMapping("/{albumId}/{userId}")
	public ResponseEntity<List<Review>> deleteReview(@PathVariable("albumId") Long albumId, @PathVariable("userId") String userId){
		
		reviewService.deleteReview(albumId, userId);
		List<Review> reviews = reviewService.getReviewListByAlbum(Album.builder().id(albumId).build());
		
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}
	
	//리뷰 수정 요청
	@Transactional
	@PutMapping("/{albumId}")
	public ResponseEntity<List<Review>> updateReview(@PathVariable("albumId") Long albumId, @RequestBody Review review){
		
		reviewService.updateReview(review);
		List<Review> reviews = reviewService.getReviewListByAlbum(Album.builder().id(albumId).build());
		
		return new ResponseEntity<>(reviews, HttpStatus.CREATED);
	}
}
