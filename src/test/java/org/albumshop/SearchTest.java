package org.albumshop;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.persistence.AlbumRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchTest {

	@Autowired
	AlbumRepository abRepo;
	
	@Test
	public void TestFindByTitle() {
		
		List<Album> ablist = abRepo.findByTitleContaining("앨");
		System.out.println(ablist);
		
	}
}
