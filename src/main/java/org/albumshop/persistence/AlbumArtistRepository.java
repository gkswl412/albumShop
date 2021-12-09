package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.AlbumArtist;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlbumArtistRepository extends PagingAndSortingRepository<AlbumArtist, Long> {

	
	List<AlbumArtist> findByAlbum(long id);
	
}
