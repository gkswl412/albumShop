package org.albumshop.service;

import org.albumshop.domain.Album;
import org.albumshop.domain.Cart;
import org.albumshop.domain.MultiIdUserAlbum;
import org.albumshop.domain.User;
import org.albumshop.persistence.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
/*
    @Autowired
    AlbumRepository albumRepository;

    public static Cart createCart(User user, Album album, int count) {
        MultiIdUserAlbum multiIdUserAlbum = MultiIdUserAlbum.builder()
                .user(user).album(album).build();

        Cart cart = Cart.builder()
                .multiId(multiIdUserAlbum).quantity(count).build();

        return cart;
    }
*/

}
