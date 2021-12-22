package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {

	List<Album> findByTitleContaining(String title);
	List<Album> findByGenreContaining(String genre);
	
	@Query(value = "SELECT * from album group by genre", nativeQuery = true )
	List<Album> findAllByGenre();
	
	@Query(value = "select count(id) from album ", nativeQuery = true)
	public Long countAllById();
}
