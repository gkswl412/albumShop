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
    public String cartAll(Model model) throws Exception {
        User user = userRepository.findById("kosta0").get();

        List<CartDetailVO> cartDetailList = cartDetailService.getCartList(user.getId());

        model.addAttribute("cartlist", cartDetailList);
        return "cart";
    }
}
