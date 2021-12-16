package org.albumshop;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;

import java.util.ArrayList;
import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.domain.MultiIdUserAlbum;
import org.albumshop.domain.Review;
import org.albumshop.domain.User;
import org.albumshop.persistence.AlbumRepository;
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
	
	@Test
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
			Review review = Review.builder().multiId(multiId).rating(multiId.getAlbum().getId()<6L?multiId.getAlbum().getId():3).likeCount(10).build();
			review.setContent(review.getRating()>3?"정말 좋아요!":"나쁘지 않아요");
			System.out.println(review);
			reviewRepo.save(review);
		});
	}
}
