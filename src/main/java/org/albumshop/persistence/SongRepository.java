package org.albumshop.persistence;

import org.albumshop.domain.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long>{

}
