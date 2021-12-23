package org.albumshop.persistence;

import java.util.Optional;

import org.albumshop.domain.User;
import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<User, String>{
	
	Optional<User> findByNickName(String nickName);
	Optional<User> findByEmail(String email);

	
}
