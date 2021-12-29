package org.albumshop.service.manager;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.albumshop.domain.Delivery;
import org.albumshop.domain.User;

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
public class AccountService {

    @Autowired
    UserRepository userRepo;

    Pageable paging = PageRequest.of(0, 10, Sort.Direction.DESC, "id");

    //create account
    public User createUser(User User){
        String id = User.getId();
        userRepo.save(User);
        Optional<User> optional = userRepo.findById(id);
        return optional.orElse(null);
    }

    //read accountInfo
    public User readUser(String id) {
        Optional<User> optional = userRepo.findById(id);
        return optional.orElse(null);
    }

    //read allAccountInfo
    public List<User> readAllUsers() {
        Page<User> page = userRepo.findAll(paging);
        if(page.hasContent()){
            return page.getContent();
        }
        return null;
    }

    //update account
    public User updateUser(User user){
        String id = user.getId();
        Optional<User> optional = userRepo.findById(id);
        if (optional.isPresent()) {
            userRepo.save(user);
            return user;
        }
        return null;
    }

    //delete account
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
