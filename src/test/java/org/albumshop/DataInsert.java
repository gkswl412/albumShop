package org.albumshop;

import java.time.LocalDate;

import org.albumshop.domain.Song;
import org.albumshop.domain.User;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.SongRepository;
import org.albumshop.persistence.UserRepository;
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
