package org.albumshop;

import org.albumshop.persistence.AlbumRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlbumDetailTest {
	
	@Autowired
	AlbumRepository albumRepo;
	
	//@Test
	public void selectAlbumById() {
		albumRepo.findById(5L).ifPresent(album->{
			System.out.println(album);
		});
	}
}
