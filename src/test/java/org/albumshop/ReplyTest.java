package org.albumshop;

import java.util.Arrays;

import org.albumshop.domain.MultiIdUserReviewReply;
import org.albumshop.domain.ReviewReply;
import org.albumshop.domain.ReviewReplyDisLike;
import org.albumshop.domain.ReviewReplyLike;
import org.albumshop.persistence.ReviewReplyDisLikeRepository;
import org.albumshop.persistence.ReviewReplyLikeRepository;
import org.albumshop.persistence.ReviewReplyRepository;
import org.albumshop.persistence.ReviewRepository;
import org.albumshop.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReplyTest {
	
	@Autowired
	ReviewRepository reviewRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	ReviewReplyRepository replyRepo;
	@Autowired
	ReviewReplyLikeRepository repleLikeRepo;
	@Autowired
	ReviewReplyDisLikeRepository repleDisLikeRepo;
	
	@Test
	public void countByMultiIdReviewReply() {
		ReviewReply reviewReply = ReviewReply.builder().id(3L).build();
		System.out.println(repleLikeRepo.countByMultiIdReviewReply(reviewReply));
	}
	
	//@Test
	public void getLikedReplyList() {
		repleLikeRepo.getLikedReplyList(1L, "asdf1111", "zzzz").forEach(item->{
			System.out.println(item);
		});
	}
	
	//@Test
	public void getLikeCountPerReplyInReview() {
		repleLikeRepo.getLikeCountPerReplyInReview(1L,"asdf1111").forEach(i->{
			System.out.println(Arrays.toString(i));
		});
	}
	
	//@Test
	public void insertReplyLike() {
		replyRepo.findByReviewMultiIdAlbumIdAndReviewMultiIdUserId(1L, "asdf1111").forEach(reply->{
			userRepo.findAll().forEach(user->{
				MultiIdUserReviewReply multiId = MultiIdUserReviewReply.builder().user(user).reviewReply(reply).build();
				ReviewReplyLike replyLike = ReviewReplyLike.builder().multiId(multiId).build();
				ReviewReplyDisLike replyDisLike = ReviewReplyDisLike.builder().multiId(multiId).build();
				repleLikeRepo.save(replyLike);
				repleDisLikeRepo.save(replyDisLike);
			});
		});
	}
	
	//@Test
	public void getReplies() {
		replyRepo.findByReviewMultiIdAlbumIdAndReviewMultiIdUserId(1L,"kosta0").forEach(reply->{
			System.out.println(reply);
		});
	}
	
	//@Test
	public void getReplyCountPerReviewInAlbum() {
		replyRepo.getReplyCountPerReviewInAlbum(1L).forEach(i->{
			System.out.println(Arrays.toString(i));
		});
	}
	
	//@Test
	public void ReplyInsertTest() {
		reviewRepo.findAll().forEach(review->{
			userRepo.findAll().forEach(user->{
				ReviewReply reply = ReviewReply.builder().review(review).user(user).content("ㅋㅋ공감").build();
				replyRepo.save(reply);
			});
			
		});
	}
}
