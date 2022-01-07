package org.albumshop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.albumshop.domain.*;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.CartDetailRepository;
import org.albumshop.persistence.CartRepository;
import org.albumshop.persistence.UserRepository;
import org.albumshop.service.CartDetailService;
import org.albumshop.service.CartService;
import org.albumshop.vo.CartDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class CartController {
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

    @RequestMapping(value = "/cart")
    public String cartAll(Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("msg", "장바구니에 진입하려면 로그인하세요.");
            return "redirect:user/login";
        }
        System.out.println(user.getId());
        List<CartDetailVO> cartDetailList = null;

        if (user != null) {
            cartDetailList = cartDetailService.getCartList(user);
        }

        model.addAttribute("cartlist", cartDetailList);
        return "cart/list";

    }

/*    @RequestMapping(value = "/cart/order/{cartId}")
    public String orderAll(Model model) {
        User user = (User) session.getAttribute("user");

        List<CartDetailVO> cartDetailList = null;

        if (user != null) {
            cartDetailList = cartDetailService.getCartList(user);
        }

        model.addAttribute("cartlist", cartDetailList);

        return "delivery/order";
    }*/

    @RequestMapping(value = "/cart/add/")
    public String addCart(Model model, HttpServletRequest httpServletRequest) {

        Long cartId = Long.parseLong(httpServletRequest.getParameter("cartId"));
        Long albumId = Long.parseLong(httpServletRequest.getParameter("albumId"));
        String userId = httpServletRequest.getParameter("userId");

        System.out.println(cartId);
        System.out.println(albumId);
        System.out.println(userId);

        User user = userRepository.findById(userId).get();
        System.out.println(user);

        if (user == null) {
            model.addAttribute("msg", "장바구니에 진입하려면 로그인하세요.");
            return "redirect:user/login";
        }
/*        Long cartId = 19L;
        Long albumId = 1L;*/
        cartDetailRepository.insertIntoCartDetail(cartId, albumId);

        /*Cart cart = cartRepository.findById(cartId).get();
        if (cart == null) {
            cart = cartService.createCart(userId);
            cartId = cart.getId();
        }
        Album album = albumRepository.findById(albumId).get();

        CartDetail cartDetail = CartDetail.createCartDetail(cart, album, 1);
        cartService.addCart(cartDetail, userId);*/

        return "cart/list";
    }



    @PatchMapping(value = "/cart/insert/{cartId}/{albumId}")
    public @ResponseBody ResponseEntity insertCartDetail (@PathVariable("cartId") Long cartId, @PathVariable("albumId") Long albumId, String userId) {
        Cart cart = cartRepository.findById(cartId).get();
        if (cart == null) {
            cart = cartService.createCart(userId);
            cartId = cart.getId();
        }
        Album album = albumRepository.findById(albumId).get();

        CartDetail cartDetail = CartDetail.createCartDetail(cart, album, 1);
        cartService.addCart(cartDetail, userId);
        return new ResponseEntity<Long>(cartId, HttpStatus.OK);
    }

    @RequestMapping(value = "/cart/update/{cartId}/{albumId}")
    public @ResponseBody ResponseEntity updateCartDetail (@PathVariable("cartId") Long cartId, @PathVariable("albumId") Long albumId, int count) {
/*        if (count <= 0) {
            return new ResponseEntity<String>("최소 1개 이상 담아주세요.", HttpStatus.BAD_REQUEST);
        } else if (!cartService.validateCartItem(cartId, albumId, "kosta0"*//*principal.getName()*//*)) {
            return new ResponseEntity<String>("수정 권한이 없습니다.", HttpStatus.FORBIDDEN);
        }*/

        cartService.updateCartDetailCount(cartId, albumId, count);
        return new ResponseEntity<Long>(cartId, HttpStatus.OK);
    }

    @RequestMapping(value = "/cart/delete/{cartId}/{albumId}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity deleteCartDetail (@PathVariable("cartId") Long cartId, @PathVariable("albumId") Long albumId) {
        cartService.deleteCartDetail(cartId, albumId);
        return new ResponseEntity<Long>(cartId, HttpStatus.OK);
    }

    @RequestMapping(value = "/cart/delete/{cartId}/all", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity deleteCartDetailAll(@PathVariable("cartId") Long cartId) {
        cartDetailService.deleteCartDetailAll(cartId);
        return new ResponseEntity<Long>(cartId, HttpStatus.OK);
    }
}
