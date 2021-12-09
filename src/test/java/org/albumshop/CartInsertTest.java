package org.albumshop;

import org.albumshop.domain.Album;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

@SpringBootTest
public class CartInsertTest {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    AlbumRepository albumRepository;

    //@Test
    public void selectAlbum() {
        albumRepository.findAll().forEach(album -> {
            System.out.println(album);
        });
    }

    //@Test
    public void insertAlbumToCart() {
        //8, 9, 10번 앨범 각 1, 2, 3개 Cart에 담기
        LongStream.rangeClosed(8L, 10L).forEach(i -> {
            albumRepository.findById(i).ifPresent(album -> {
                //cartRepository.save();
            });
        });
    }
}
