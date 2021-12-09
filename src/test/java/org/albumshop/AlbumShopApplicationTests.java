package org.albumshop;

import java.time.LocalDate;

import org.albumshop.domain.Album;
import org.albumshop.domain.ArtistGroup;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.ArtistGroupRepository;
import org.albumshop.persistence.ArtistRepository;
import org.albumshop.persistence.ReviewRepository;
import org.albumshop.persistence.SongRepository;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlbumShopApplicationTests {

	
	@Autowired
	UserRepository uRepo;
	@Autowired
	AlbumRepository abRepo;
	@Autowired
	SongRepository sRepo;
	@Autowired
	ArtistGroupRepository agRepo;
	@Autowired
	ArtistRepository aRepo;
	@Autowired
	ReviewRepository rRepo;
	
	
	// @Test
	public void albuminsert() {
		for (int i=0;i<10;i++) {
		Album album = new Album();
		album.setTitle("앨범 제목"+i);
		LocalDate releasedate = LocalDate.of(2000+i, 1+i, 11+i);
		album.setReleaseDate(releasedate);
		album.setDescription("앨범 설명"+i);
		album.setPrice(i*1000+20000);
		album.setRemaining(i*10);
		if(i==0) {
			album.setGenre("락");
		}else if(i==1 | i==2) {
			album.setGenre("발라드");
		}else if(i==3 | i==4) {
			album.setGenre("R&B");
		}else if(i==5 | i==6) {
			album.setGenre("째즈");
		}else if(i==7 | i==8) {
			album.setGenre("힙합");
		}else {
			album.setGenre("댄스");
		}
		abRepo.save(album);
		}
	}
	
	// @Test
	public void ArtistGroupinsert() {
		//ArtistGroup ag = ArtistGroup.builder().name("아티스트그룹A").debutDate("2000-10-2")
		ArtistGroup ag1 = new ArtistGroup();
		ag1.setName("아티스트그룹A");
		ag1.setDebutDate(LocalDate.of(2000, 10, 1));
		agRepo.save(ag1);
		
		ArtistGroup ag2 = new ArtistGroup();
		ag2.setName("아티스트그룹B");
		ag2.setDebutDate(LocalDate.of(2001, 9, 11));
		agRepo.save(ag2);
	}
	
	
	
	
}
