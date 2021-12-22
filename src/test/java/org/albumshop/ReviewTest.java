package org.albumshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.albumshop.domain.Album;
import org.albumshop.domain.MultiIdUserAlbum;
import org.albumshop.domain.MultiIdUserReview;
import org.albumshop.domain.Review;
import org.albumshop.domain.ReviewLike;
import org.albumshop.domain.User;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.ReviewLikeRepository;
import org.albumshop.persistence.ReviewRepository;
import org.albumshop.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReviewTest {
	
	@Autowired
	ReviewRepository reviewRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	AlbumRepository albumRepo;
	@Autowired
	ReviewLikeRepository reviewLikeRepo;
	
	//@Test
	public void test2() {
		reviewLikeRepo.getLikedReviewList("kosta5", 1L).forEach(i->{
			System.out.println(i);
		});
	}
	
	//@Test
	public void test1() {
		Map<String, Long> result = new HashMap<>();
		reviewLikeRepo.getLikeCount(1L).forEach(i->{
			result.put((String)i[0],(long) i[1]);
		});
		System.out.println(result);
	}
	
	//@Test
	public void insertReviewLike() {
		Album album = Album.builder().id(1L).build();
		reviewRepo.findByMultiIdAlbum(album).forEach(review->{
			userRepo.findAll().forEach(user->{
				MultiIdUserReview multiId = MultiIdUserReview.builder().user(user).review(review).build();
				ReviewLike reviewLike = ReviewLike.builder().multiId(multiId).build();
				reviewLikeRepo.save(reviewLike);
			});
		});
	}
	
	//@Test
	public void deleteReviewById() {
		User user = User.builder().id("kosta0").build();
		Album album = Album.builder().id(1L).build();
		MultiIdUserAlbum id = MultiIdUserAlbum.builder().user(user).album(album).build();
		reviewRepo.findById(id).ifPresentOrElse(review->{
			reviewRepo.deleteById(review.getMultiId());
		}, ()->{
			System.out.println("해당 리뷰는 존재하지 않습니다.");
		});
	}
	
	//@Test
	public void getReviewByAlbumId() {
		Album album = Album.builder().id(9L).build();
		reviewRepo.findByMultiIdAlbum(album).forEach(review->{
			System.out.println(review);
		});
	}
	
	//@Test
	public void reviewInsert() {
		List<MultiIdUserAlbum> multiIds = new ArrayList<>();
		userRepo.findAll().forEach(user->{
			albumRepo.findAll().forEach(album->{
				multiIds.add(MultiIdUserAlbum.builder().album(album).user(user).build());
			});
		});
		/*multiIds.forEach(i->{
			System.out.println(i.getUser().getId());
			System.out.println(i.getAlbum().getId());
		});*/
		multiIds.forEach(multiId->{
			Review review = Review.builder().multiId(multiId).rating(multiId.getAlbum().getId()<6L?multiId.getAlbum().getId():3).build();
			review.setContent(review.getRating()>3?"정말 좋아요!":"나쁘지 않아요");
			System.out.println(review);
			reviewRepo.save(review);
		});
	}
}
