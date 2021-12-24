package org.albumshop.service.manager;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// The role of service is
// 1. "basic CRUD" between controller and repository.
// 2. "verification of CRUD action" with boolean return value.
// 3. detecting  "abnormal value" of Domain member.
// etc??
@Service
@Transactional
public interface ManagerService<T, R extends CrudRepository<T, ?>> {


    default <T> T create(T t) {
        return t;
    }

    default <T> T readById(Long id) {
        T t = null;
        return t;
    }

    <T> T update(T t);

    default <T> T deleteById(Long id){
        T t = null;
        return t;
    }

}
