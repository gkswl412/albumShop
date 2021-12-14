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

    public List<CartDetailVO> getCartList(String userId) throws Exception {
        List<CartDetailVO> cartDetailList = new ArrayList<>();
        User user = userRepository.findById(userId).orElseThrow(Exception::new);
        Cart cart = cartRepository.findByUserId(user.getId());
        if (cart == null) {
            return cartDetailList;
        }

        // cartDetailList = cartDetailRepository.findByCartDetailVOList(cart.getId());

        return cartDetailList;
    }


}
