package org.albumshop.persistence;

import org.albumshop.domain.MyList;
import org.springframework.data.repository.CrudRepository;

public interface MyListRepository extends CrudRepository<MyList, Long>{

    
}
