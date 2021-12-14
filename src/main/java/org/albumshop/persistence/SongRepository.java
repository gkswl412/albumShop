package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.Album;
import org.albumshop.domain.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long>{
	
	List<Song> findByAlbum(Album album);
}
