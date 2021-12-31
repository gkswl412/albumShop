package org.albumshop.controller;

import org.albumshop.domain.User;
import org.albumshop.persistence.*;
import org.albumshop.service.CartDetailService;
import org.albumshop.service.CartService;
import org.albumshop.vo.CartDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

public class DeliveryController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartDetailRepository cartDetailRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    CartService cartService;
    @Autowired
    CartDetailService cartDetailService;
    @Autowired
    HttpSession session;


    @RequestMapping(value = "/delivery/order")
    public String orderAlbum(Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:user/login";
        }
        System.out.println(user.getId());
        List<CartDetailVO> cartDetailList = null;

        if (user != null) {
            cartDetailList = cartDetailService.getCartList(user);
        }
        System.out.println("delivery");
        model.addAttribute("cartlist", cartDetailList);
        return "delivery/order";
    }
}
