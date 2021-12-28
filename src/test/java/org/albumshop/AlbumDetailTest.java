package org.albumshop;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.domain.Review;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.ReviewRepository;
import org.albumshop.persistence.SongRepository;
import org.albumshop.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;

@SpringBootTest
public class AlbumDetailTest {
	
	@Autowired
	AlbumRepository albumRepo;
	@Autowired
	SongRepository songRepo;
	@Autowired
	ReviewRepository reRepo;
	@Autowired
	UserRepository userRepo;
	
	//@Test
	public void selectAlbumById() {
		albumRepo.findById(5L).ifPresent(album->{
			System.out.println(album);
		});
	}
	
	//@Test
	public void findAllById() {
		Album album = Album.builder().id(9L).build();
		songRepo.findByAlbum(album).forEach(song->{
			System.out.println(song);
		});
	}
	
	@Test
	public void findReviewById() {
		List<Review> List= reRepo.findReviewById("kosta2");
		System.out.println(List);
	}
}
