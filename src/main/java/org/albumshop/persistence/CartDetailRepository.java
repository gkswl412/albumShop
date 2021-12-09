package org.albumshop.persistence;

import org.albumshop.domain.CartDetail;
import org.albumshop.domain.MultiIdCartAlbum;
import org.springframework.data.repository.CrudRepository;

public interface CartDetailRepository extends CrudRepository<CartDetail, MultiIdCartAlbum> {
    //CartDetail findByCartIdAndAlbumId(Long cartId, Long albumId);
}
