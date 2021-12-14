package org.albumshop.persistence;

import org.albumshop.domain.AlbumArtist;
import org.albumshop.domain.Delivery;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
}
