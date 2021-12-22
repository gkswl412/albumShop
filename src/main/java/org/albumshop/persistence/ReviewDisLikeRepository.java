package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.MultiIdUserReview;
import org.albumshop.domain.ReviewDisLike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReviewDisLikeRepository extends CrudRepository<ReviewDisLike, MultiIdUserReview>{
	
	@Query("select rl.multiId.review.multiId.user.id, count(rl.multiId.review.multiId.user.id) "
			+ "from ReviewDisLike rl where rl.multiId.review.multiId.album.id = ?1 "
			+ "group by rl.multiId.review.multiId.user.id")
	public List<Object[]> getDisLikeCount(Long albumId);
	
	@Query("select rl.multiId.review.multiId.user.id from ReviewDisLike rl where rl.multiId.user.id  = ?1 and rl.multiId.review.multiId.album.id = ?2")
	public List<String> getDisLikedReviewList(String userId, Long albumId);
}
