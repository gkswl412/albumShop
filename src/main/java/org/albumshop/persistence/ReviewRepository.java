package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.domain.MultiIdUserAlbum;
import org.albumshop.domain.Review;
import org.albumshop.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, MultiIdUserAlbum>{
	
	public List<Review> findByMultiIdAlbum(Album album);
	
	@Query(value = "select COUNT(rating) from review where album_id=?1 group by album_id ", nativeQuery = true )
	public Long countRatingByAlbumId(Long id);
	
	@Query(value = "select count(rating) from review ", nativeQuery = true)
	public Long countAllById();
	
	@Query(value = "SELECT ROUND(SUM(rating)/COUNT(rating), 1) "
		+ "from review "
		+ "WHERE album_id = ?1 group by album_id " , nativeQuery = true)
	public Double avgRatingByAlbumId(Long id);
	
	@Query(value="SELECT b.id, b.cover, b.title, a.content, a.rating "
		+ "from review a join album b on a.album_id = b.id "
		+ "where a.user_id =?1", nativeQuery = true)
	public List<Object[]> findReviewById(String userId);
} 