package org.albumshop.persistence;

import org.albumshop.domain.QuestionReply;
import org.springframework.data.repository.CrudRepository;

public interface QuestionReplyRepository extends CrudRepository<QuestionReply, Long> {
}
