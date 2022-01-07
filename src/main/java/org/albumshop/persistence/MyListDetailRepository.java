package org.albumshop.persistence;

import org.albumshop.domain.MultiIdMyListAlbum;
import org.albumshop.domain.MyListDetail;
import org.springframework.data.repository.CrudRepository;

public interface MyListDetailRepository extends CrudRepository<MyListDetail, MultiIdMyListAlbum>{
	
}
