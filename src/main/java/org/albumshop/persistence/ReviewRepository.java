package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.domain.MultiIdUserAlbum;
import org.albumshop.domain.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, MultiIdUserAlbum>{
	
	public List<Review> findByMultiIdAlbum(Album album);
	
	@Query(value = "select COUNT(rating) from review where album_id=?1 group by album_id ", nativeQuery = true )
	public Long countByMultiIdAlbum(Long id);
	
	@Query(value = "select count(rating) from review ", nativeQuery = true)
	public Long countAllById();
} 