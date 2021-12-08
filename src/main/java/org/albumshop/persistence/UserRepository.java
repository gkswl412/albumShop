package org.albumshop.persistence;

import org.albumshop.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>{

}
