package org.albumshop.persistence;

import java.util.List;
import java.util.Map;

import org.albumshop.domain.Album;
import org.albumshop.domain.MultiIdUserReview;
import org.albumshop.domain.ReviewLike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReviewLikeRepository extends CrudRepository<ReviewLike, MultiIdUserReview>{
	
	/*
	 * select review_user_id, count(review_user_id) from review_like where
	 * review_album_id =1 group by review_user_id;
	 */
	
	@Query("select rl.multiId.review.multiId.user.id, count(rl.multiId.review.multiId.user.id) "
			+ "from ReviewLike rl where rl.multiId.review.multiId.album.id = ?1 "
			+ "group by rl.multiId.review.multiId.user.id")
	public List<Object[]> getLikeCount(Long albumId);
	
	
}
