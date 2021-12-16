package org.albumshop.persistence;

import org.albumshop.domain.Cart;
import org.albumshop.domain.MultiIdUserAlbum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
    @Query("select c from Cart c where c.user.id=?1")
    Cart findByUserId(String user_id);
}
