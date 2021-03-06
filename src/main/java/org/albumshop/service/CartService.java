package org.albumshop.service;

import lombok.RequiredArgsConstructor;
import org.albumshop.domain.*;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.CartDetailRepository;
import org.albumshop.persistence.CartRepository;
import org.albumshop.persistence.UserRepository;
import org.albumshop.vo.CartDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
@Transactional
public class CartService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartDetailRepository cartDetailRepository;
    @Autowired
    AlbumRepository albumRepository;

    public Long cartIdFindByUserId(String userId) {
        return cartRepository.findByUserId(userId).getId();
    }

    public Cart createCart(String userId) {
        Cart cart;
        if (cartRepository.findByUserId(userId) == null) {
            User user = userRepository.findById(userId).get();
            cart = Cart.createCart(user);
            cartRepository.save(cart);
        } else {
            cart = cartRepository.findByUserId(userId);
        }

        return cart;
    }
    public boolean insertCart(Long cartId, Long albumId, String userId) {
        User user = userRepository.findById(userId).orElse(null);
        Cart cart = cartRepository.findById(cartId).orElse(null);
        Album album = albumRepository.findById(albumId).orElse(null);
        MultiIdCartAlbum multiIdCartAlbum = MultiIdCartAlbum.builder()
                .cart(cart).album(album).build();
        CartDetail cartDetail = cartDetailRepository.findById(multiIdCartAlbum).orElse(null);

        if (cartDetail == null) {

        }

        return true;
    }

    public MultiIdCartAlbum addCart(CartDetail cartDetail, String userId) {
        Album album = albumRepository.findById(cartDetail.getMultiId().getAlbum().getId())
                .orElseThrow(EntityNotFoundException::new);
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);

        Cart cart = cartRepository.findByUserId(userId);

        if (cart == null) {
            cart = Cart.createCart(user);
            cartRepository.save(cart);
        }

        CartDetail savedCartAlbum = cartDetailRepository.findByCartIdAndAlbumId(cart.getId(), album.getId());

        if (savedCartAlbum != null) {
            savedCartAlbum.addQuantity(cartDetail.getQuantity());
            return savedCartAlbum.getMultiId();
        } else {
            CartDetail newCartDetail = CartDetail.createCartDetail(cart, album, cartDetail.getQuantity());
            cartDetailRepository.save(newCartDetail);
            return newCartDetail.getMultiId();
        }

    }
    @Transactional(readOnly = true)
    public boolean validateCartItem(Long cartId, Long albumId, String userId) {
        User curUser = userRepository.findById(userId).orElse(null);
        Cart cart = cartRepository.findById(cartId).orElse(null);
        Album album = albumRepository.findById(albumId).orElse(null);
        MultiIdCartAlbum multiIdCartAlbum = MultiIdCartAlbum.builder()
                .cart(cart).album(album).build();
        CartDetail cartDetail = cartDetailRepository.findById(multiIdCartAlbum).orElse(null);
        User savedUser = cartDetail.getMultiId().getCart().getUser();

        if (!curUser.getId().equals(savedUser.getId())) {
            return false;
        } else return true;
    }

    public void updateCartDetailCount(Long cartId, Long albumId, int count) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        Album album = albumRepository.findById(albumId).orElse(null);
        MultiIdCartAlbum multiIdCartAlbum = MultiIdCartAlbum.builder()
                .cart(cart).album(album).build();
        CartDetail cartDetail = cartDetailRepository.findById(multiIdCartAlbum).orElse(null);
        cartDetail.updateQuantity(count);
    }

    public void deleteCartDetail(Long cartId, Long albumId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        Album album = albumRepository.findById(albumId).orElse(null);
        MultiIdCartAlbum multiIdCartAlbum = MultiIdCartAlbum.builder()
                .cart(cart).album(album).build();
        CartDetail cartDetail = cartDetailRepository.findById(multiIdCartAlbum).orElse(null);
        cartDetailRepository.delete(cartDetail);
    }

    public void orderCartDetail1(Long cartId, List<Long> albumIds) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        ArrayList<Album> albums = new ArrayList<>();

        IntStream.rangeClosed(0, albumIds.size()-1).forEach(i -> {
            Album album = albumRepository.findById(albumIds.get(i)).orElse(null);
            albums.add(album);
        });

        ArrayList<CartDetailVO> cartDetails = new ArrayList<>();

    }


}
