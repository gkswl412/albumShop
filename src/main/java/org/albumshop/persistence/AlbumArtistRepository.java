package org.albumshop.persistence;

import org.albumshop.domain.AlbumArtist;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlbumArtistRepository extends PagingAndSortingRepository<AlbumArtist, Long> {
	
}