package org.albumshop.service;

import org.albumshop.domain.*;
import org.albumshop.persistence.*;
import org.albumshop.vo.DeliveryDetailVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeliveryDetailService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartDetailRepository cartDetailRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    DeliveryDetailRepository deliveryDetailRepository;
    @Autowired
    DeliveryRepository deliveryRepository;

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

    public List<DeliveryDetailVO> getDeliveryList(String userId) {
        List<Object[]> deliveryList = deliveryDetailRepository.findByUserId(userId);

        List<DeliveryDetailVO> deliveryDetailVOList = new ArrayList<>();
        for (Object[] obj : deliveryList) {
            Long deliveryId = Long.parseLong(String.valueOf(obj[0]));
            Timestamp deliveryRegDate = Timestamp.valueOf(String.valueOf(obj[1]));
            String deliveryRequest = String.valueOf(obj[2]);
            Timestamp deliveryUpdateDate = Timestamp.valueOf(String.valueOf(obj[3]));
            String destinationAddress = String.valueOf(obj[4]);
            String orderState = String.valueOf(obj[5]);
            //userId -> obj[7]
            //bb.delivery_id -> obj[8]
            String albumTitle = String.valueOf(obj[7]);
            //int orderAmount = Integer.parseInt(String.valueOf(obj[0]));
            //Long albumId = Long.parseLong(String.valueOf(obj[1]));

            DeliveryDetailVO deliveryDetailVO = DeliveryDetailVO.builder()
                    .deliveryId(deliveryId)
                    .deliverUpdateDate(deliveryUpdateDate)
                    .deliveryRegDate(deliveryRegDate)
                    .deliveryRequest(deliveryRequest)
                    .destinationAddress(destinationAddress)
                    .orderState(orderState)
                    .albumTitle(albumTitle)
                    .userId(userId)
                    .build();

            System.out.println(deliveryDetailVO);

            deliveryDetailVOList.add(deliveryDetailVO);
        }

        return deliveryDetailVOList;
    }

    public void getDeliveryDetail(String userId) {

    }
}
