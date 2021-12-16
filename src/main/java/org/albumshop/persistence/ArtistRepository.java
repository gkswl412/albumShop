package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long>{

	List<Artist> findByNameContaining(String name);
}
