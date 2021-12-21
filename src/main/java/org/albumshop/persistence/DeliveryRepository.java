package org.albumshop.persistence;


import org.albumshop.domain.Delivery;
import org.albumshop.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {

    Page<Delivery> findAll(Pageable paging);

    Page<Delivery> findByOrderState(String orderState, Pageable paging);

    Page<Delivery> findByUser(User user, Pageable paging);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE #{#entityName} d " +
            "SET d.orderState = :state " +
            "WHERE d.id = :id")
    void updateDelivery(@Param("id") Long id,
                        @Param("state") String orderState);

    void deleteDeliveryById(Long id);








}
