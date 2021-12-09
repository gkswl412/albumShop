package org.albumshop.controller;

import org.albumshop.domain.Cart;
import org.albumshop.persistence.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
    @Autowired
    CartRepository cartRepository;
    @RequestMapping(value = "/cart")
    public String cartAll(Model model) {
        return "albumshop/cart";
    }
}
