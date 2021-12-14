package org.albumshop;

import java.time.LocalDate;

import org.albumshop.domain.*;
import org.albumshop.persistence.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataInsert {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	AlbumRepository albumRepo;
	@Autowired
	SongRepository songRepo;
	@Autowired
	ArtistRepository artistRepo;
	@Autowired
	ArtistGroupRepository artistGroupRepo;
	@Autowired
	AlbumArtistRepository albumArtistRepo;
	@Autowired
	DeliveryRepository deliveryRepo;
	@Autowired
	PurchaseReviewRepository purchaseReviewRepo;

	//@Test
	public void deliveryTest(){
		for(long i = 0; i < 3; i++){
			Delivery delivery = Delivery.builder().id(i * 10 + 1).build();
		}
	}

	@Test
	public void insertAlbumArtist() {
		for(long i=0;i<3;i++) {
			Album album = Album.builder().id(i*2 + 1).build();
			Album album2 = Album.builder().id(i*2 + 2).build();
			Artist artist = Artist.builder().id(i+5).build();
			AlbumArtist albumArtist = AlbumArtist.builder().album(album).artist(artist).build();
			AlbumArtist albumArtist2 = AlbumArtist.builder().album(album2).artist(artist).build();
			albumArtistRepo.save(albumArtist);
			albumArtistRepo.save(albumArtist2);
		}
		Album album = Album.builder().id(7L).build();
		Album album2 = Album.builder().id(8L).build();
		ArtistGroup artistGroup = ArtistGroup.builder().Id(4L).build();
		AlbumArtist albumArtist = AlbumArtist.builder().album(album).artistGroup(artistGroup).build();
		AlbumArtist albumArtist2 = AlbumArtist.builder().album(album2).artistGroup(artistGroup).build(); 
		albumArtistRepo.save(albumArtist);
		albumArtistRepo.save(albumArtist2);
		
		Album album3 = Album.builder().id(9L).build();
		Artist artist = Artist.builder().id(5L).build();
		Artist artist2 = Artist.builder().id(6L).build();
		AlbumArtist albumArtist3 = AlbumArtist.builder().album(album3).artist(artist).build();
		AlbumArtist albumArtist4 = AlbumArtist.builder().album(album3).artist(artist2).build();
		albumArtistRepo.save(albumArtist3);
		albumArtistRepo.save(albumArtist4);
		
		Album album4 = Album.builder().id(10L).build();
		Artist artist3 = Artist.builder().id(7L).build();
		AlbumArtist albumArtist5 = AlbumArtist.builder().album(album4).artist(artist3).build();
		AlbumArtist albumArtist6 = AlbumArtist.builder().album(album4).artistGroup(artistGroup).build();
		albumArtistRepo.save(albumArtist5);
		albumArtistRepo.save(albumArtist6);
	}
	
	//@Test
	public void insertArtist() {
		for(int i=0;i<7;i++) {
			LocalDate birth = LocalDate.of(1980+i, 1+i, 1+i);
			LocalDate debutDate = LocalDate.of(2000+i, 1+i, 1+i);
			Artist artist = Artist.builder()
					.birth(birth)
					.debutDate(debutDate)
					.gender(i%2==0?"남자":"여자")
					.name("김지수"+i)
					.photo("images/testImage.jpg")
					.build();
			if(i<4) {
				ArtistGroup artistGroup = new ArtistGroup();
				artistGroup.setId(4L);
				artist.setArtistGroup(artistGroup);
			}
			artistRepo.save(artist);
		}
	}
	
	//@Test
	public void insertArtistGroup() {
		for(int i=0;i<1;i++) {
			LocalDate debutDate = LocalDate.of(2000+i, 1+i, 1+i);
			ArtistGroup artistGroup = ArtistGroup.builder().name("포맨"+i).photo("images/testImage.jpg").debutDate(debutDate).build();
			artistGroupRepo.save(artistGroup);
		}
	}
	
	//@Test
	public void insertSong() {
		albumRepo.findAll().forEach(album->{
			for(int i=0;i<5;i++) {
				Song song = Song.builder().album(album).trackNum(i+1).playTime(200+i).title("붉은 노을" + i).isThisSongTitle(i==0?1:0).build();
				songRepo.save(song);
			}
		});
	}
	
	//@Test
	public void inserUser() {
		for(int i=0;i<10;i++) {
			User user = new User();
			user.setAddress("제주도 서귀포시 " + i);
			LocalDate birthDate = LocalDate.of(1990+i, 1+i, 1+i);
			user.setBirth(birthDate);
			user.setEmail("abc" + i + "@kost.com");
			if(i%2==0) {
				user.setGender("남자");
			}else {
				user.setGender("여자");
			}
			if(i==0) {
				user.setGrade("Diamond");
			}else if(i==1 | i==2) {
				user.setGrade("Gold");
			}else if(i==3 | i==4 | i==5) {
				user.setGrade("Silver");
			}else {
				user.setGrade("Bronze");
			}
			user.setId("kosta" + i);
			user.setName("홍길동" + i);
			user.setNickName("노랭이" + i);
			user.setPass("1234");
			user.setPhone("010-1234-567"+i);
			user.setScore(0);
			userRepo.save(user);
		}
	}
}
