package org.albumshop.controller;

import org.albumshop.domain.Cart;
import org.albumshop.persistence.CartDetailRepository;
import org.albumshop.persistence.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartDetailRepository cartDetailRepository;
    @RequestMapping(value = "/cart")
    public String cartAll(Model model) {
        Cart cart = cartRepository.findByUserId("kosta0");
        model.addAttribute("cartlist", cart);
        return "cart";
    }
}
