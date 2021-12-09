package org.albumshop.persistence;

import org.albumshop.domain.CartDetail;
import org.albumshop.domain.MultiIdCartAlbum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CartDetailRepository extends CrudRepository<CartDetail, MultiIdCartAlbum> {
    @Query("select cd from CartDetail cd where cd.multiId.cart = ?1 and cd.multiId.album = ?2")
    CartDetail findByCartIdAndAlbumId(Long cartId, Long albumId);
}
