package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long>{

	List<Artist> findByNameContaining(String name);
	
	@Query(value = "select count(id) from artist ", nativeQuery = true)
	public Long countAllById();
}
