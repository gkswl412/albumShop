package org.albumshop.persistence;

import org.albumshop.domain.AlbumArtist;
import org.albumshop.domain.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
