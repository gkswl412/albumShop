package org.albumshop.persistence;


import org.albumshop.domain.Delivery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {

    Page<Delivery> findDeliveryById(long id, Pageable paging);

    Page<Delivery> findAll(Pageable paging);

    Page<Delivery> findDeliveriesByOrderState(String orderState, Pageable paging);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE #{#entityName} d" +
            " SET d.orderState = :state" +
            " WHERE d.id = :id")
    void updateOrderState(@Param("id") long id, @Param("state") String orderState);

    void deleteDeliveryById(Long id);








}
