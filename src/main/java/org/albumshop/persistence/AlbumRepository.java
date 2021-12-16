package org.albumshop.persistence;

import java.util.List;

import org.albumshop.domain.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {

	List<Album> findByTitleContaining(String title);
}
