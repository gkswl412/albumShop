package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.MyList;
import org.albumshop.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MyListRepository extends CrudRepository<User, String>{

    
}
