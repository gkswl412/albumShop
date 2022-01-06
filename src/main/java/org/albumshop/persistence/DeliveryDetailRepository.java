package org.albumshop.persistence;

import org.albumshop.domain.DeliveryDetail;
import org.albumshop.domain.MultiIdDeliveryAlbum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeliveryDetailRepository extends CrudRepository<DeliveryDetail, MultiIdDeliveryAlbum> {
/*
    @Query("select dd "
        + "from DeliveryDetail d "
        + "where d  d.multiId.delivery.id = ?1 and dd.multiId.album = ?2")
    DeliveryDetail findBDeliveryIdAndAlbumId(Long cartId, Long albumId);
*/


    //DeliveryDetail findByUserId(String userId);

    @Query(value = "select d.id, d.delivery_reg_date, d.delivery_request, d.delivery_update_date, d.destination_address, d.order_state, d.user_id, a.title from delivery_detail dd join delivery d on dd.delivery_id = d.id join album a on dd.album_id = a.id where d.user_id = ?1 group by d.id, d.delivery_reg_date order by d.delivery_reg_date desc", nativeQuery = true)
    List<Object[]> findByUserId(String userId);
}
