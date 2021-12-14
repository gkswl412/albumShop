package org.albumshop.persistence;

import org.albumshop.domain.CartDetail;
import org.albumshop.domain.MultiIdCartAlbum;
import org.albumshop.vo.CartDetailVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartDetailRepository extends CrudRepository<CartDetail, MultiIdCartAlbum> {
    @Query("select cd from CartDetail cd where cd.multiId.cart = ?1 and cd.multiId.album = ?2")
    CartDetail findByCartIdAndAlbumId(Long cartId, Long albumId);

    //@Query()
    //List<CartDetailVO> findByCartDetailVOList(Long cartId);
}
