package org.albumshop;

import org.albumshop.domain.Album;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlbumDetailTest {
	
	@Autowired
	AlbumRepository albumRepo;
	@Autowired
	SongRepository songRepo;
	
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
}
