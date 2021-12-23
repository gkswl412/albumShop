package org.albumshop.persistence;

import org.albumshop.domain.MultiIdUserReviewReply;
import org.albumshop.domain.ReviewReplyDisLike;
import org.springframework.data.repository.CrudRepository;

public interface ReviewReplyDisLikeRepository extends CrudRepository<ReviewReplyDisLike, MultiIdUserReviewReply>{

}
