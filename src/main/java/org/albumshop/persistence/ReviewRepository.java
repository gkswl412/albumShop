package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.domain.MultiIdUserAlbum;
import org.albumshop.domain.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, MultiIdUserAlbum>{
	
	public List<Review> findByMultiIdAlbum(Album album);
}