package org.albumshop.controller;

import java.util.Map;

import javax.transaction.Transactional;

import org.albumshop.domain.Review;
import org.albumshop.domain.ReviewReply;
import org.albumshop.service.ReplyService;
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
@RequestMapping("/reply/*")
public class ReplyRestController {
	
	@Autowired
	ReplyService service;
	
	//댓글 리스트 요청
	@GetMapping("/{albumId}/{userId}")
	public ResponseEntity<Map<String, Object>> getReplyList(
			@PathVariable("albumId") Long albumId, 
			@PathVariable("userId") String userId){
		Map<String, Object> result = service.getReplies(albumId, userId);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	//좋아요 싫어요 수정 요청
	@Transactional
	@PostMapping("/thumb/{replyId}/{job}")
	public Map<String, Object> createEmpathy(
			@PathVariable("replyId") Long replyId,
			@PathVariable("job") String job){
		return service.checkEmpathyTable(replyId, job);
	}
	
	//댓글 등록 요청
	@Transactional
	@PostMapping("/{userId}/{albumId}")
	public ResponseEntity<Map<String, Object>> createReply(
			@PathVariable("userId") String userId, 
			@PathVariable("albumId") Long albumId,
			@RequestBody ReviewReply reply){
		service.createReply(reply);
		Map<String, Object> result = service.getReplies(albumId, userId);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	//댓글 삭제 요청
	@Transactional
	@DeleteMapping("/{replyId}/{userId}/{albumId}")
	public ResponseEntity<Map<String, Object>> deleteReply(
			@PathVariable("replyId") Long replyId,
			@PathVariable("userId") String userId, 
			@PathVariable("albumId") Long albumId){
		service.deleteReply(replyId);
		Map<String, Object> result = service.getReplies(albumId, userId);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	//댓글 수정 요청
	@Transactional
	@PutMapping("/{replyId}/{userId}/{albumId}")
	public ResponseEntity<Map<String, Object>> updateReply(
			@PathVariable("replyId") Long replyId,
			@PathVariable("userId") String userId, 
			@PathVariable("albumId") Long albumId,
			String content){
		service.updateReply(replyId,content);
		Map<String, Object> result = service.getReplies(albumId, userId);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

}