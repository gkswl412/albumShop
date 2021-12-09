package org.albumshop.service;

import org.albumshop.domain.*;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.CartDetailRepository;
import org.albumshop.persistence.CartRepository;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
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
}
