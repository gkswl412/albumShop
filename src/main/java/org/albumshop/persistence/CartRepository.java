package org.albumshop.persistence;

import org.albumshop.domain.Cart;
import org.albumshop.domain.MultiIdUserAlbum;
import org.albumshop.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CartRepository extends CrudRepository<Cart, Long> {
    @Query("select c from Cart c where c.user.id=?1")
    Cart findByUserId(String user_id);

    @Transactional
    @Modifying
    @Query(value = "insert into cart (user_id) value (?1)", nativeQuery = true)
    void insertIntoCartByUserId(String user_id);

    //void save(User user);

}
