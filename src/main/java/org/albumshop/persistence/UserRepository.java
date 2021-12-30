package org.albumshop.persistence;

import java.util.List;
import java.util.Optional;
import org.albumshop.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>{

	
	Optional<User> findByNickName(String nickName);
	Optional<User> findByEmail(String email);
    
	Optional<User> findById(String id);
    Page<User> findAll(Pageable paging);

    void deleteById(String s);
   
}
