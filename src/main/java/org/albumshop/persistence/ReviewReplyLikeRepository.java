package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.MultiIdUserReviewReply;
import org.albumshop.domain.ReviewReply;
import org.albumshop.domain.ReviewReplyLike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReviewReplyLikeRepository extends CrudRepository<ReviewReplyLike, MultiIdUserReviewReply>{
	
	//특정 리뷰(특정유저의 특정앨범에대한 리뷰)의 댓글들 각각의 좋아요 개수 얻기
	//select review_reply_id,count(*) from review_reply_like rrl left outer join review_reply rr on(rrl.review_reply_id = rr.id) where rr.review_album_id = 1 and rr.review_user_id = 'asdf1111' group by review_reply_id;
	@Query("select rrl.multiId.reviewReply.id, count(*) from ReviewReplyLike rrl left outer join ReviewReply rr on(rrl.multiId.reviewReply.id = rr.id) where rr.review.multiId.album.id = ?1 and rr.review.multiId.user.id = ?2 group by rrl.multiId.reviewReply.id")
	public List<Object[]> getLikeCountPerReplyInReview(Long albumId, String userId);
	
	//좋아요 표시한 댓글 목록 얻기
	@Query("select rrl.multiId.reviewReply.id from ReviewReplyLike rrl left outer join ReviewReply rr on(rrl.multiId.reviewReply.id = rr.id) where rr.review.multiId.album.id = ?1 and rr.review.multiId.user.id = ?2 and rrl.multiId.user.id = ?3")
	public List<Long> getLikedReplyList(Long reviewAlbumId, String reviewUserId, String userId);
	
	//좋아요 혹은 싫어요 클릭후 DB에서 바뀐 공감개수 가져오기위한 counting
	public Long countByMultiIdReviewReply(ReviewReply reviewReply);
}
