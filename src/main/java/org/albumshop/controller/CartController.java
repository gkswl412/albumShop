package org.albumshop.controller;

import lombok.RequiredArgsConstructor;
import org.albumshop.domain.Cart;
import org.albumshop.domain.CartDetail;
import org.albumshop.domain.MultiIdCartAlbum;
import org.albumshop.domain.User;
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
    CartService cartService;
    @Autowired
    CartDetailService cartDetailService;

    @RequestMapping(value = "/cart")
    public String cartAll(Model model) {
        User user = userRepository.findById("kosta0").orElse(null);

        List<CartDetailVO> cartDetailList = cartDetailService.getCartList(user);
/*        IntStream.rangeClosed(0, cartDetailList.size()-1).forEach(i -> {
            System.out.println(cartDetailList.get(i));
        });*/
        if (cartDetailList != null) {
            model.addAttribute("cartlist", cartDetailList);
            return "cart/list";
        } else {
            return "cart/empty";
        }
    }

    @PatchMapping(value = "/cart/update/{cartId}/{albumId}")
    public @ResponseBody ResponseEntity updateCartDetail (@PathVariable("cartId") Long cartId, @PathVariable("albumId") Long albumId, int count/*, Principal principal*/) {
        if (count <= 0) {
            return new ResponseEntity<String>("최소 1개 이상 담아주세요.", HttpStatus.BAD_REQUEST);
        } else if (!cartService.validateCartItem(cartId, albumId, "kosta0"/*principal.getName()*/)) {
            return new ResponseEntity<String>("수정 권한이 없습니다.", HttpStatus.FORBIDDEN);
        }

        cartService.updateCartDetailCount(cartId, albumId, count);
        return new ResponseEntity<Long>(cartId, HttpStatus.OK);
    }

    @RequestMapping(value = "/cart/delete/{cartId}/{albumId}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity deleteCartDetail (@PathVariable("cartId") Long cartId, @PathVariable("albumId") Long albumId/*, Principal principal*/) {
        if(!cartService.validateCartItem(cartId, albumId, "kosta0" /*principal.getName()*/)) {
            return new ResponseEntity<String>("삭제 권한이 없습니다.", HttpStatus.FORBIDDEN);
        }

        cartService.deleteCartDetail(cartId, albumId);
        return new ResponseEntity<Long>(albumId, HttpStatus.OK);
    }

    @RequestMapping(value = "/cart/delete/{cartId}/all", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity deleteCartDetailAll(@PathVariable("cartId") Long cartId) {
        cartDetailService.deleteCartDetailAll(cartId);
        return new ResponseEntity<Long>(cartId, HttpStatus.OK);
    }
}
