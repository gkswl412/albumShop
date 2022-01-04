package org.albumshop;

import java.util.Arrays;
import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.domain.MyList;
import org.albumshop.domain.Review;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.MyListRepository;
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
	@Autowired
	MyListRepository mylistRepo;
	
	@Test
	public void test() {
		userRepo.findById("zzzz").ifPresent(user->{
			MyList mylist = MyList.builder().user(user).myListTitle("만들어져라").build();
			mylistRepo.save(mylist);
		});
		
	}
	
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
		reRepo.findReviewById("kosta2").forEach(item->{
			System.out.println(Arrays.toString(item));
		});
	}
}
