package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {

	@Query(value = "SELECT a2.name, a3.name FROM album_artist a left join artist a2 ON a.artist_id = a2.id LEFT join artist_group a3 on a.artist_group_id=a3.id WHERE album_id=?1", nativeQuery = true)
	public List<Object[]> selectById(Long id);
	
}
