package org.albumshop.service.manager;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.albumshop.domain.Delivery;
import org.albumshop.domain.User;
import org.albumshop.persistence.DeliveryRepository;
import org.albumshop.persistence.DeliveryRepository;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Delivery1Service {

    @Autowired
    UserRepository userRepo;
    @Autowired
    DeliveryRepository deliveryRepo;

    Pageable paging = PageRequest.of(0, 10, Sort.Direction.DESC, "id");

    // create delivery
    public Delivery createDelivery(String userId, String destinationAddress,
        String deliveryRequest, String orderState) {
        Optional<User> optional = userRepo.findById(userId);
        if (optional.isPresent()) {
            User user = optional.get();
            Delivery delivery = Delivery.builder()
                .user(user)
                .destinationAddress(destinationAddress)
                .deliveryRequest(deliveryRequest)
                .deliveryRegDate(new Timestamp(System.currentTimeMillis()))
                .deliveryUpdateDate(new Timestamp(System.currentTimeMillis()))
                .orderState(orderState)
                .build();
            deliveryRepo.save(delivery);
            return delivery;
        } else return null;
    }

    // read delivery
    public Delivery readDelivery(Long id) {
        Optional<Delivery> optional = deliveryRepo.findById(id);
        return optional.orElse(null);
    }

    //read all delivery
    public List<Delivery> readAllDeliverys() {
        Page<Delivery> page = deliveryRepo.findAll(paging);
        if(page.hasContent()){
            return page.getContent();
        }
        return null;
    }

    //update delivery
    public Delivery updateDelivery(Long deliveryId, String destinationAddress,
        String deliveryRequest, String orderState) {
        Optional<Delivery> optional = deliveryRepo.findById(deliveryId);
        if (optional.isPresent()) {
            Delivery delivery = optional.get();
            delivery = Delivery.builder()
                .destinationAddress(destinationAddress)
                .deliveryRequest(deliveryRequest)
                .deliveryUpdateDate(new Timestamp(System.currentTimeMillis()))
                .orderState(orderState)
                .build();
            deliveryRepo.save(delivery);
            return delivery;
        } else return null;
    }

    // delete delivery
    public boolean deleteDelivery(Long id) {
        Optional<Delivery> optional = deliveryRepo.findById(id);
        if (optional.isPresent()) {
            deliveryRepo.deleteById(optional.get().getId());
            Optional<Delivery> check = deliveryRepo.findById(id);
            return !check.isPresent();
        }
        return false;
    }

}
