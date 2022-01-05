package org.albumshop.controller;

import lombok.RequiredArgsConstructor;
import org.albumshop.domain.User;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.CartDetailRepository;
import org.albumshop.persistence.CartRepository;
import org.albumshop.persistence.UserRepository;
import org.albumshop.service.CartDetailService;
import org.albumshop.service.CartService;
import org.albumshop.vo.CartDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
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
    CartService cartService;
    @Autowired
    CartDetailService cartDetailService;
    @Autowired
    HttpSession session;

    @PostMapping(value = "/delivery/order")
    public String orderCart(Model model) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:user/login";
        }

        System.out.println(user.getId());
        List<CartDetailVO> cartDetailList = null;

        if (user != null) {
            cartDetailList = cartDetailService.getCartList(user);
        }

        model.addAttribute("cartlist", cartDetailList);
        return "delivery/orderPage";
    }
}
