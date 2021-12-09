package org.albumshop.persistence;

import org.albumshop.domain.AlbumArtist;
import org.springframework.data.repository.CrudRepository;

public interface AlbumArtistRepository extends CrudRepository<AlbumArtist, Long> {

}
