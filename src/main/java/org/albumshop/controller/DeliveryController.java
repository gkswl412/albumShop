package org.albumshop.controller;

import lombok.RequiredArgsConstructor;
import org.albumshop.domain.Delivery;
import org.albumshop.domain.User;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.CartDetailRepository;
import org.albumshop.persistence.CartRepository;
import org.albumshop.persistence.UserRepository;
import org.albumshop.service.CartDetailService;
import org.albumshop.service.CartService;
import org.albumshop.service.DeliveryService;
import org.albumshop.vo.CartDetailVO;
import org.albumshop.vo.DeliveryAlbumVO;
import org.albumshop.vo.DeliveryDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    DeliveryService deliveryService;
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

    @PostMapping(value = "/delivery/order/pay")
    public String orderSuccess(Model model) {

        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:user/login";
        }

        return "delivery/orderSuccess";
    }

    @RequestMapping(value = "/delivery/list")
    public String deliveryList(Model model) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:user/login";
        }

        String userId = user.getId();

        List<DeliveryDetailVO> deliveryList = deliveryService.getDeliveryList(userId);
        model.addAttribute("deliverylist", deliveryList);

        return "delivery/list";
    }

    @GetMapping(value = "/delivery/detail")
    public String deliveryDetailList(Model model, Long deliveryId) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:user/login";
        }

        String userId = user.getId();

        List<DeliveryAlbumVO> deliveryAlbumList = deliveryService.getDeliveryDetail(deliveryId);
        Delivery delivery = deliveryService.getDeliveryDetailById(deliveryId);

        model.addAttribute("deliveryAlbmuList", deliveryAlbumList);
        model.addAttribute("deliveryDetail", delivery);
        model.addAttribute("userId", userId);

        return "delivery/detail";
    }
}
