package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.ArtistGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ArtistGroupRepository extends CrudRepository<ArtistGroup, Long>{

	List<ArtistGroup> findByNameContaining(String name);
	
	@Query(value = "select count(id) from artist_group ", nativeQuery = true)
	public Long countAllById();
}
