package org.albumshop.service.manager;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import org.albumshop.domain.Delivery;
import org.albumshop.persistence.DeliveryRepository;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// The role of service is
// 1. "basic CRUD" between controller and repository.
// 2. "verification of CRUD action" with boolean return value.
// 3. detecting  "abnormal value" of Domain member.
// etc??
@Service
@Transactional
public class DeliveryService implements ManagerService {

    @Autowired
    DeliveryRepository deliRepo;
    @Autowired
    UserRepository userRepo;

    //create order
    public boolean createDelivery(Delivery delivery){
        Long id = delivery.getId();
        deliRepo.save(delivery);
        if (deliRepo.findById(id).isPresent()) {
            return true;
        } else {
            return false;
        }
    }
    //read order
    public Delivery readDelivery(Long id) {
        Optional<Delivery> optional = deliRepo.findById(id);
        if(optional != null) {
            return optional.get();
        }
        return null;
    }

    public boolean updateDelivery(Long id, String orderState){
        Optional<Delivery> optional = deliRepo.findById(id);
        if (optional.isPresent()) {
            Delivery delivery = optional.get();
            delivery.setOrderState(orderState);
            delivery.setDeliveryUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
            return true;
        } else {
            return false;
        }
    }

    //delete order
    public boolean deleteDelivery(Long id) {
        Optional<Delivery> optional = deliRepo.findById(id);
        if (optional.isPresent()) {
            deliRepo.deleteById(optional.get().getId());
            return true;
        } else {
            return false;
        }
    }

}
