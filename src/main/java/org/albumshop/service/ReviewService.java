package org.albumshop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.albumshop.domain.Album;
import org.albumshop.domain.MultiIdUserAlbum;
import org.albumshop.domain.Review;
import org.albumshop.domain.User;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.ReviewDisLikeRepository;
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
	private ReviewDisLikeRepository reviewDisLikeRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private AlbumRepository albumRepo;
	@Autowired
	private HttpSession session;
	
	//리뷰 목록
	public Map<String,Object> getReviewListByAlbum(Album album) throws RuntimeException {
		Map<String, Object> output = new HashMap<>();
		Map<String, Long> reviewLikeCountList = getReviewLikeCount(album.getId());
		Map<String, Long> reviewDisLikeCountList = getReviewDisLikeCount(album.getId());
		List<Review> reviews = reviewRepo.findByMultiIdAlbum(album);
		User user = (User) session.getAttribute("user");
		List<String> likedReviewList = getLikedReviewList(user.getId(),album.getId());
		List<String> disLikedReviewList = getDisLikedReviewList(user.getId(),album.getId());
		output.put("likeCount", reviewLikeCountList);
		output.put("disLikeCount", reviewDisLikeCountList);
		output.put("reviews", reviews);
		output.put("likedReviewList", likedReviewList);
		output.put("disLikedReviewList", disLikedReviewList);
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
	
	//싫어요 개수 얻기
	public Map<String,Long> getReviewDisLikeCount(Long albumId) {
		Map<String,Long> reviewDisLikeCountList = new HashMap<>();
		reviewDisLikeRepo.getDisLikeCount(albumId).forEach(item->{
			reviewDisLikeCountList.put((String) item[0], (Long) item[1]);
		});
		return reviewDisLikeCountList;
	}
	
	//좋아요 표시한 리뷰 얻기
	public List<String> getLikedReviewList(String userId, Long albumId) {
		return reviewLikeRepo.getLikedReviewList(userId, albumId);
	}
	
	//싫어요 표시한 리뷰 얻기
	public List<String> getDisLikedReviewList(String userId, Long albumId) {
		return reviewDisLikeRepo.getDisLikedReviewList(userId, albumId);
	}
	
	public String checkEmpathyTable(String userId, Long albumId, String job) {
		User user = (User) session.getAttribute("user");
		if(reviewLikeRepo.getLikedReviewList(userId, albumId).contains(user.getId())) {
			System.out.println("공감했던 리뷰");
		}else if(reviewDisLikeRepo.getDisLikedReviewList(userId, albumId).contains(user.getId())) {
			System.out.println("비공감했던 리뷰");
		}else {
			System.out.println("어떤 감정표현도 하지않았던 리뷰");
		}
		return job;
	}
}
