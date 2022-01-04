package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.MultiIdUserReview;
import org.albumshop.domain.Review;
import org.albumshop.domain.ReviewLike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReviewLikeRepository extends CrudRepository<ReviewLike, MultiIdUserReview>{
	
	@Query("select rl.multiId.review.multiId.user.id, count(rl.multiId.review.multiId.user.id) "
			+ "from ReviewLike rl where rl.multiId.review.multiId.album.id = ?1 "
			+ "group by rl.multiId.review.multiId.user.id")
	public List<Object[]> getLikeCount(Long albumId);
	
	@Query("select rl.multiId.review.multiId.user.id "
		+ "from ReviewLike rl "
		+ "where rl.multiId.user.id  = ?1 and rl.multiId.review.multiId.album.id = ?2")
	public List<String> getLikedReviewList(String userId, Long albumId);
	
	//좋아요 혹은 싫어요 클릭후 DB에서 바뀐 공감개수 가져오기위한 Counting
	public Long countByMultiIdReview(Review review);
}
