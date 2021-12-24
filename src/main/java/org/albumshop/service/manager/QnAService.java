package org.albumshop.service.manager;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import org.albumshop.domain.Delivery;
import org.albumshop.domain.User;
import org.albumshop.persistence.DeliveryRepository;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QnAService {

    @Autowired
    UserRepository qnaRepo;

    //create order
    public User createUser(User User){
        String id = User.getId();
        qnaRepo.save(User);
        Optional<User> optional = qnaRepo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    //read order
    public User readUser(String id) {
        Optional<User> optional = qnaRepo.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public User updateUser(User User){
        String id = User.getId();
        Optional<User> optional = qnaRepo.findById(id);
        if (optional.isPresent()) {
            User target = optional.get();
            qnaRepo.save(target);
            return target;
        }
        return null;
    }

    //delete order
    public boolean deleteUser(String id) {
        Optional<User> optional = qnaRepo.findById(id);
        if (optional.isPresent()) {
            qnaRepo.deleteById(optional.get().getId());
            return true;
        } else {
            return false;
        }
    }

}
