package org.albumshop.persistence;

import org.albumshop.domain.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long>{

}
