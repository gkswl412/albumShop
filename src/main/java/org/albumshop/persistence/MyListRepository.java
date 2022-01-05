package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.MyList;
import org.albumshop.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MyListRepository extends CrudRepository<MyList, Long>{

	@Query(value="SELECT id, my_list_title from my_list WHERE user_id=?1", nativeQuery = true)
	public List<Object[]> findMyAlbumById1(String userId);
	
	public List<MyList> findByUser(User user);
}
