package org.albumshop.persistence;

import org.albumshop.domain.CartDetail;
import org.albumshop.domain.MultiIdCartAlbum;
import org.albumshop.vo.CartDetailVO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartDetailRepository extends CrudRepository<CartDetail, MultiIdCartAlbum> {
    @Query("select cd from CartDetail cd where cd.multiId.cart = ?1 and cd.multiId.album = ?2")
    CartDetail findByCartIdAndAlbumId(Long cartId, Long albumId);

    @Query(value = "select * from\n" +
            "(select * from view_cart) vc\n" +
            "join\n" +
            "(select album.id, album.cover, album.price, album.remaining, album.title, group_concat(vaa.artist_id separator ',') as artist_id, group_concat(vaa.artist_group_id separator ',') as artist_group_id, group_concat(vaa.name separator ' / ') as artist_name\n" +
            " from album join view_album_artist vaa\n" +
            "                 on album.id = vaa.album_id group by id) va\n" +
            "    on vc.album_id = va.id\n" +
            "where cart_id = ?1", nativeQuery = true)
    List<Object[]> findByCartDetailVOList(Long cartId);

    @Transactional
    @Modifying
    @Query(value = "delete from cart_detail where cart_id = ?1", nativeQuery = true)
    void deleteByCartId(Long cartId);
}
