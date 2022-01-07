package org.albumshop.service;


import org.albumshop.domain.Cart;
import org.albumshop.domain.User;
import org.albumshop.persistence.CartDetailRepository;
import org.albumshop.persistence.CartRepository;
import org.albumshop.persistence.UserRepository;
import org.albumshop.vo.CartDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CartDetailService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartDetailRepository cartDetailRepository;

    public List<CartDetailVO> getCartList(User user) {
        List<Object[]> cartDetailObjList;
        Cart cart = cartRepository.findByUserId(user.getId());
        if (cart == null) {
            return null;
        }

        cartDetailObjList = cartDetailRepository.findByCartDetailVOList(cart.getId());
        if (cartDetailObjList == null) {
            return null;
        } else {
            List<CartDetailVO> cartDetailVOList = new ArrayList<>();
            for (Object[] obj : cartDetailObjList) {
                Long cartId = Long.parseLong(String.valueOf(obj[0]));
                String userId = String.valueOf(obj[1]);
                Long albumId = Long.parseLong(String.valueOf(obj[2]));
                int quantity = Integer.parseInt(String.valueOf(obj[3]));
                String cover = String.valueOf(obj[5]);
                int price = Integer.parseInt(String.valueOf(obj[6]));
                int remaining = Integer.parseInt(String.valueOf(obj[7]));
                String albumTitle = String.valueOf(obj[8]);
                String artistId = String.valueOf(obj[9]);
                String artistGroupId = String.valueOf(obj[10]);
                String artistName = String.valueOf(obj[11]);
                CartDetailVO cartDetailVO = CartDetailVO.builder()
                        .cartId(cartId).userId(userId).albumId(albumId).quantity(quantity)
                        .cover(cover).price(price).remaining(remaining)
                        .albumTitle(albumTitle).artistId(artistId).artistGroupId(artistGroupId)
                        .artistName(artistName)
                        .build();
                cartDetailVOList.add(cartDetailVO);
            }

            return cartDetailVOList;
        }

    }

    public void deleteCartDetailAll(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        cartDetailRepository.deleteByCartId(cart.getId());
    }
}
