package org.albumshop.persistence;

import org.albumshop.domain.Cart;
import org.albumshop.domain.MultiIdUserAlbum;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {

    //Cart findByUserId(String id);
}
