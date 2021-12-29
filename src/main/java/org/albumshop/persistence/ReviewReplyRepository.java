package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.ReviewReply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReviewReplyRepository extends CrudRepository<ReviewReply, Long>{
	//리뷰별 댓글 갯수 가져오기
	@Query("select rr.review.multiId.user.id, count(*) from ReviewReply rr where rr.review.multiId.album.id = ?1 group by rr.review.multiId.user.id")
	public List<Object[]> getReplyCountPerReviewInAlbum(Long albumId);
	
	public List<ReviewReply> findByReviewMultiIdAlbumIdAndReviewMultiIdUserId(Long albumId, String userId);
}
