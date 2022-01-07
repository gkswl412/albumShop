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
	
	// select *,if(id in (select my_list_id from my_list_detail where album_id=1),'true','false') from my_list where user_id='zzzz';
	@Query(value="select ml.id, ml.myListTitle, case when ml.id in(select mld.multiId.myList.id from MyListDetail mld where mld.multiId.album.id=?1) then 'true' else 'false' end from MyList ml where ml.user.id=?2")
	public List<Object[]> getAllMyList(Long albumId, String userId);
	
	@Query(value="select mld.multiId.myList.id from MyListDetail mld where mld.multiId.album.id=?1")
	public List<Long> getMyListId(Long albumId);
}
