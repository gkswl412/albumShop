package org.albumshop.persistence;

import java.util.List;
import java.util.Optional;
import org.albumshop.domain.Delivery;
import org.albumshop.domain.MyList;
import org.albumshop.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {

    //Pageable paging = Pageable.

    Optional<Delivery> findById(Long l);

    Page<Delivery> findAll(Pageable paging);

    Page<Delivery> findByOrderState(String orderState, Pageable paging);

    Page<Delivery> findByUser(User user, Pageable paging);
    
    @Query("select del from delivery wgere del.user.id=?1")
	List<Delivery> findDelivertByUserId(String user_id, Pageable paging);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE #{#entityName} d " +
            "SET d.orderState = :state " +
            "WHERE d.id = :id")
    void updateDeliveryOrderState(@Param("id") Long id,
                        @Param("state") String orderState);

    void deleteById(Long id);

}
