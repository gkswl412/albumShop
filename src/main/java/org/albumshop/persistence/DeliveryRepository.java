package org.albumshop.persistence;

import java.util.Optional;
import org.albumshop.domain.Delivery;
import org.albumshop.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {

    Optional<Delivery> findById(Long l);

    Page<Delivery> findAll(Pageable paging);

    Page<Delivery> findByOrderState(String orderState, Pageable paging);

    Page<Delivery> findByUser(User user, Pageable paging);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE #{#entityName} d " +
            "SET d.orderState = :state " +
            "WHERE d.id = :id")
    void updateDeliveryOrderState(@Param("id") Long id,
                        @Param("state") String orderState);

    void deleteById(Long id);

    Delivery findByUserId(String userId);
}
