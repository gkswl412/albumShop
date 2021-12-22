package org.albumshop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.albumshop.domain.Album;
import org.albumshop.domain.MultiIdUserAlbum;
import org.albumshop.domain.Review;
import org.albumshop.domain.User;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.ReviewLikeRepository;
import org.albumshop.persistence.ReviewRepository;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepo;
	@Autowired
	private ReviewLikeRepository reviewLikeRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AlbumRepository albumRepo;
	
	//리뷰 목록
	public Map<String,Object> getReviewListByAlbum(Album album) throws RuntimeException {
		Map<String, Object> output = new HashMap<>();
		Map<String, Long> reviewLikeCountList = getReviewLikeCount(album.getId());
		List<Review> reviews = reviewRepo.findByMultiIdAlbum(album);
		output.put("likeCount", reviewLikeCountList);
		output.put("reviews", reviews);
		return output;
	}
	
	//리뷰 등록 
	public boolean createReview(Review review){
		if(reviewRepo.save(review) != null) {
			return true;
		}
		return false;
	}
	
	//리뷰 삭제
	public void deleteReview(Long albumId, String userId) {
		MultiIdUserAlbum multiId = new MultiIdUserAlbum();
		multiId.setId(userId, albumId);
		reviewRepo.findById(multiId).ifPresentOrElse(item->{
			reviewRepo.deleteById(item.getMultiId());
		}, ()->{
			System.out.println("해당 리뷰는 존재하지 않습니다.");
		});
	}
	
	//리뷰 수정
	public boolean updateReview(Review review) {
		if(reviewRepo.save(review) != null) {
			return true;
		}
		return false;
	}
	
	//유저 정보 얻기
	public User getUserInfo(String userId) {
		return userRepo.findById(userId).get();
	}
	
	//특정 유저의 리뷰 정보 얻기
	public Review getReviewByUser(User user, Album album) {
		MultiIdUserAlbum multiId = MultiIdUserAlbum.builder().user(user).album(album).build();
		return reviewRepo.findById(multiId).get();
	}
	
	//좋아요 개수 얻기
	public Map<String,Long> getReviewLikeCount(Long albumId) {
		Map<String,Long> reviewLikeCountList = new HashMap<>();
		reviewLikeRepo.getLikeCount(albumId).forEach(item->{
			reviewLikeCountList.put((String) item[0], (Long) item[1]);
		});
		return reviewLikeCountList;
	}
	
}
