package org.albumshop;

import org.albumshop.domain.Album;
import org.albumshop.domain.Cart;
import org.albumshop.domain.CartDetail;
import org.albumshop.domain.User;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.CartDetailRepository;
import org.albumshop.persistence.CartRepository;
import org.albumshop.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@SpringBootTest
public class CartInsertTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    CartDetailRepository cartDetailRepository;

    //@Test
    public void selectAlbum() {
        albumRepository.findAll().forEach(album -> {
            System.out.println(album);
        });
    }

    @Test
    public void insertAlbumToCart() {
        //8, 9, 10번 앨범 각 1, 2, 3개 Cart에 담기
        List<Album> albumList = new ArrayList<>();
        LongStream.rangeClosed(8L, 10L).forEach(i -> {
            albumRepository.findById(i).ifPresent(album -> {
                albumList.add(album);
            });
        });

        userRepository.findById("kosta0").ifPresent(user -> {
            Cart cart = Cart.createCart(user);
            cartRepository.save(cart);
            IntStream.range(0, 3).forEach(j -> {
                CartDetail cartDetail = CartDetail.createCartDetail(cart, albumList.get(j), j+1);
                cartDetailRepository.save(cartDetail);
            });
        });



    }
}
