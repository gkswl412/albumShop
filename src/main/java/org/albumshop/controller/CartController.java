package org.albumshop.controller;

import org.albumshop.domain.Cart;
import org.albumshop.domain.CartDetail;
import org.albumshop.domain.User;
import org.albumshop.persistence.CartDetailRepository;
import org.albumshop.persistence.CartRepository;
import org.albumshop.persistence.UserRepository;
import org.albumshop.service.CartDetailService;
import org.albumshop.service.CartService;
import org.albumshop.vo.CartDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.IntStream;

@Controller
public class CartController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartDetailRepository cartDetailRepository;
    @Autowired
    CartService cartService;
    @Autowired
    CartDetailService cartDetailService;

    @RequestMapping(value = "/cart")
    public String cartAll(Model model) {
        User user = userRepository.findById("kosta0").orElse(null);

        List<CartDetailVO> cartDetailList = cartDetailService.getCartList(user);
        IntStream.rangeClosed(0, cartDetailList.size()-1).forEach(i -> {
            System.out.println(cartDetailList.get(i));
        });
        model.addAttribute("cartlist", cartDetailList);
        return "cart/list";
    }
}
