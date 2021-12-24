package org.albumshop.persistence;

import java.util.List;
import java.util.Optional;
import org.albumshop.domain.Delivery;
import org.albumshop.domain.MyList;
import org.albumshop.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DeliveryRepository extends CrudRepository<Delivery, Long> {


}
