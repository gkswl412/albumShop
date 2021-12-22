package org.albumshop.persistence;

import org.albumshop.domain.MultiIdUserReview;
import org.albumshop.domain.ReviewDisLike;
import org.springframework.data.repository.CrudRepository;

public interface ReviewDisLikeRepository extends CrudRepository<ReviewDisLike, MultiIdUserReview>{

}
