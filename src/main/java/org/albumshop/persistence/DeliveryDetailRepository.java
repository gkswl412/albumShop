package org.albumshop.persistence;

import org.albumshop.domain.DeliveryDetail;
import org.albumshop.domain.MultiIdDeliveryAlbum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryDetailRepository extends CrudRepository<DeliveryDetail, MultiIdDeliveryAlbum> {
/*
    @Query("select dd "
        + "from DeliveryDetail d "
        + "where d  d.multiId.delivery.id = ?1 and dd.multiId.album = ?2")
    DeliveryDetail findBDeliveryIdAndAlbumId(Long cartId, Long albumId);
*/

}
