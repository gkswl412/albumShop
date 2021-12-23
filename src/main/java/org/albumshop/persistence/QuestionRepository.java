package org.albumshop.persistence;

import java.util.Optional;
import org.albumshop.domain.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
    Optional<Question> findById(Long l);

    Page<Question> findAll(Pageable paging);

    void deleteById(Long l);
}
