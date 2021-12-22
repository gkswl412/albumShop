package org.albumshop.persistence;

import java.util.Optional;
import org.albumshop.domain.Delivery;
import org.albumshop.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>{

    Optional<User> findById(String s);

    Page<User> findAll(Pageable paging);

    void deleteById(String s);
}
