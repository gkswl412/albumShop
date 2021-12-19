package org.albumshop.service;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.domain.MultiIdUserAlbum;
import org.albumshop.domain.Review;
import org.albumshop.domain.User;
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
	private UserRepository userRepo;
	
	//리뷰 목록
	public List<Review> getReviewListByAlbum(Album album) throws RuntimeException {
		return reviewRepo.findByMultiIdAlbum(album);
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
		User user = User.builder().id(userId).build();
		Album album = Album.builder().id(albumId).build();
		MultiIdUserAlbum id = MultiIdUserAlbum.builder().user(user).album(album).build();
		reviewRepo.findById(id).ifPresentOrElse(item->{
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
		MultiIdUserAlbum id = MultiIdUserAlbum.builder().user(user).album(album).build();
		return reviewRepo.findById(id).get();
	}
	
}
