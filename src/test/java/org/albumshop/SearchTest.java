package org.albumshop;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.domain.MultiIdUserAlbum;
import org.albumshop.domain.Review;
import org.albumshop.domain.User;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.ArtistGroupRepository;
import org.albumshop.persistence.ArtistRepository;
import org.albumshop.persistence.ReviewRepository;
import org.albumshop.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchTest {

	@Autowired
	AlbumRepository abRepo;
	@Autowired
	ReviewRepository reRepo;
	@Autowired
	UserRepository usRepo;
	@Autowired
	ArtistRepository aRepo;
	@Autowired
	ArtistGroupRepository agRepo;
	
	
	// @Test
	public void TestFindByTitle() {
		List<Album> ablist = abRepo.findByTitleContaining("앨");
		System.out.println(ablist);
	}
	// @Test
	public void SongUpdateLyrics() {
	}
	
	@Test
	public void countReview() {
		//Long count = reRepo.countAllById();
		//Long count = aRepo.countAllById();
		//Long count = agRepo.countAllById();
		Long count = aRepo.countAllById();
		System.out.println(count);
		}
}
