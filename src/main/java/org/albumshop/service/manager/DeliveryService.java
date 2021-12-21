package org.albumshop.service.manager;

import javax.persistence.EntityNotFoundException;
import org.albumshop.domain.Album;
import org.albumshop.domain.Cart;
import org.albumshop.domain.CartDetail;
import org.albumshop.domain.Delivery;
import org.albumshop.domain.MultiIdCartAlbum;
import org.albumshop.domain.User;
import org.albumshop.persistence.AlbumRepository;
import org.albumshop.persistence.CartDetailRepository;
import org.albumshop.persistence.CartRepository;
import org.albumshop.persistence.DeliveryRepository;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeliveryService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    AlbumRepository albumRepository;

    public Delivery findDelivery(Delivery cartDetail, String userId) {

        return null;
    }
}
