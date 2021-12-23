package org.albumshop.service.manager;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import org.albumshop.domain.User;

import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {

    @Autowired
    UserRepository userRepo;

    //create order
    public User createUser(User User){
        String id = User.getId();
        userRepo.save(User);
        Optional<User> optional = userRepo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    //read order
    public User readUser(String id) {
        Optional<User> optional = userRepo.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public User updateUser(User user){
        String id = user.getId();
        Optional<User> optional = userRepo.findById(id);
        if (optional.isPresent()) {
            User target = optional.get();
            target = user;
            userRepo.save(target);
            return target;
        }
        return null;
    }

    //delete order
    public boolean deleteUser(String id) {
        Optional<User> optional = userRepo.findById(id);
        if (optional.isPresent()) {
            userRepo.deleteById(optional.get().getId());
            return true;
        } else {
            return false;
        }
    }
}
