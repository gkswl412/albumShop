package org.albumshop.service.manager;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.albumshop.domain.Delivery;
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
public class DeliveryService {

    @Autowired
    DeliveryRepository deliRepo;
    @Autowired
    UserRepository userRepo;

    Pageable paging = PageRequest.of(0, 10, Sort.Direction.DESC, "id");

    //create order
    public Delivery createDelivery(Delivery delivery){
        Long id = delivery.getId();
        deliRepo.save(delivery);
        Optional<Delivery> optional = deliRepo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    public Delivery readDelivery(Long id) {
        Optional<Delivery> optional = deliRepo.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public List<Delivery> readAllDeliveries() {
        Page<Delivery> page = deliRepo.findAll(paging);
        if(page.hasContent()){
            return page.getContent();
        }
        return null;
    }

    public Delivery updateDelivery(Delivery delivery){
        Long id = delivery.getId();
        Optional<Delivery> optional = deliRepo.findById(id);
        if (optional.isPresent()) {
            Delivery target = optional.get();
            target.setOrderState(delivery.getOrderState());
            target.setDeliveryUpdateDate(Timestamp.valueOf(LocalDateTime.now()));
            deliRepo.save(target);
            return target;
        }
        return null;
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
