package org.albumshop.service;

import org.albumshop.domain.*;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.CartDetailRepository;
import org.albumshop.persistence.CartRepository;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DeliveryService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartDetailRepository cartDetailRepository;
    @Autowired
    AlbumRepository albumRepository;

    public Delivery orderDelivery(Long cartId) {
        Delivery delivery = null;
        Cart cart = cartRepository.findById(cartId).orElse(null);
        User user = cart.getUser();
        delivery = Delivery.builder()
                .user(user)
                .destinationAddress(user.getAddress())
                .deliveryRequest(null)
                .orderState("ready")
                .build();



        return delivery;
    }

    public static void orderDeliverydetail(Delivery delivery, Map<Long, Integer> albumAmount) {
        ArrayList<Album> albums = new ArrayList<>();




    }
}
