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
   
    
    @Query(value="SELECT c.title, a.quantity, c.id, c.cover from cart_detail a join cart b on a.cart_id=b.id join album c on a.album_id = c.id where b.user_id = ?1", nativeQuery = true)
	public List<Object[]> findMyCartById(String userId);
	
	@Query(value="select a.my_list_title, COUNT(my_list_id) from my_list_detail b join my_list a  on a.id = b.my_list_id join album c on b.album_id = c.id where a.user_id=?1 GROUP by my_list_id ", nativeQuery = true)
	public List<Object[]> findMyAlbumById(String userId);
    
	@Query(value="select c.title, c.cover, c.genre, c.id from my_list_detail b join my_list a  on a.id = b.my_list_id join album c on b.album_id = c.id where a.user_id=?1 and a.my_list_title = ?2", nativeQuery = true)
	public List<Object[]> findMyAlbumListById(String userId, String myListTitle);
	
}
