package org.albumshop.persistence;

import java.util.Optional;
import org.albumshop.domain.QuestionReply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface QuestionReplyRepository extends CrudRepository<QuestionReply, Long> {
    Optional<QuestionReply> findById(Long l);

    Page<QuestionReply> findAll(Pageable paging);

    void deleteById(Long l);
}
