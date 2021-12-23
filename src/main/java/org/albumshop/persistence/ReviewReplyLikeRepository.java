package org.albumshop.persistence;

import org.albumshop.domain.MultiIdUserReviewReply;
import org.albumshop.domain.ReviewReplyLike;
import org.springframework.data.repository.CrudRepository;

public interface ReviewReplyLikeRepository extends CrudRepository<ReviewReplyLike, MultiIdUserReviewReply>{

}
