package org.albumshop.persistence;

import org.albumshop.domain.PurchaseReview;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseReviewRepository extends CrudRepository<PurchaseReview, Long> {
}
