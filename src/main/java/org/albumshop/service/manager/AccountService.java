package org.albumshop.service.manager;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.albumshop.domain.User;
import org.albumshop.persistence.UserRepository;
import org.albumshop.security.UserRole;
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

    // create user
    public User createUser(String id, String name, String nickName, String pass,
        String address, String email, String phone, String photo, String grade,
        Integer score, LocalDate birth, String gender, UserRole userRole) {
        // validation
        if(userRepo.findById(id).isPresent()
            || userRepo.findByNickName(nickName).isPresent()
            || userRepo.findByEmail(email).isPresent()
            || userRepo.findByPhone(phone).isPresent()) return null;

        return getUser(id, name, nickName, pass, address, email,
            phone, photo, grade, score, birth, gender, userRole);
    }

    // read user
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

    //update user
    public User updateUser(String id, String name, String nickName, String pass,
        String address, String email, String phone, String photo, String grade,
        Integer score, LocalDate birth, String gender, UserRole userRole) {
        Optional<User> optional = userRepo.findById(id);
        if (optional.isPresent()) {
            return getUser(id, name, nickName, pass, address, email,
                phone, photo, grade, score, birth, gender, userRole);
        } else return null;
    }

    private User getUser(String id, String name, String nickName, String pass, String address,
        String email, String phone, String photo, String grade, Integer score, LocalDate birth,
        String gender, UserRole userRole) {
        User user = User.builder()
            .id(id)
            .name(name)
            .nickName(nickName)
            .pass(pass)
            .address(address)
            .email(email)
            .phone(phone)
            .photo(photo)
            .grade(grade)
            .score(score)
            .birth(birth)
            .gender(gender)
            .urole(userRole)
            .build();
        userRepo.save(user);
        return user;
    }

    // delete user
    public boolean deleteUser(String id) {
        Optional<User> optional = userRepo.findById(id);
        if (optional.isPresent()) {
            userRepo.deleteById(optional.get().getId());
            Optional<User> check = userRepo.findById(id);
            return !check.isPresent();
        }
        return false;
    }
    
}
