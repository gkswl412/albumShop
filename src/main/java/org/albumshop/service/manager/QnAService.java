package org.albumshop.service.manager;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import org.albumshop.domain.Question;
import org.albumshop.domain.QuestionReply;
import org.albumshop.domain.User;
import org.albumshop.persistence.QuestionReplyRepository;
import org.albumshop.persistence.QuestionRepository;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QnAService {

    @Autowired
    UserRepository userRepo;
    @Autowired
    QuestionRepository questionRepo;
    @Autowired
    QuestionReplyRepository questionReplyRepo;

    Pageable paging = PageRequest.of(0, 10, Sort.Direction.DESC, "id");

    // create question
    public Question createQuestion(String userId, String title, String content) {
        Optional<User> optional = userRepo.findById(userId);
        if (optional.isPresent()) {
            User user = optional.get();
            Question question = Question.builder()
                .user(user)
                .title(title)
                .content(content)
                .regDate(new Timestamp(System.currentTimeMillis()))
                .updateDate(new Timestamp(System.currentTimeMillis()))
                .build();
            questionRepo.save(question);
            return question;
        } else return null;
    }

    // read question
    public Question readQuestion(Long id) {
        Optional<Question> optional = questionRepo.findById(id);
        return optional.orElse(null);
    }

    //read all question
    public List<Question> readAllQuestions() {
        Page<Question> page = questionRepo.findAll(paging);
        if(page.hasContent()){
            return page.getContent();
        }
        return null;
    }

    //update question
    public Question updateQuestion(Long questionId, String title, String content) {
        Optional<Question> optional = questionRepo.findById(questionId);
        if (optional.isPresent()) {
            Question question = optional.get();
            question = Question.builder()
                .title(title)
                .content(content)
                .updateDate(new Timestamp(System.currentTimeMillis()))
                .build();
            questionRepo.save(question);
            return question;
        } else return null;
    }

    // delete question
    public boolean deleteQuestion(Long id) {
        Optional<Question> optional = questionRepo.findById(id);
        if (optional.isPresent()) {
            questionRepo.deleteById(optional.get().getId());
            Optional<Question> check = questionRepo.findById(id);
            return !check.isPresent();
        }
        return false;
    }

    // create questionReply
    public QuestionReply createQuestionReply(Long questionId, String content) {
        Optional<Question> optional = questionRepo.findById(questionId);
        if (optional.isPresent()) {
            Question question = optional.get();
            QuestionReply questionReply = QuestionReply.builder()
                .question(question)
                .content(content)
                .regDate(new Timestamp(System.currentTimeMillis()))
                .updateDate(new Timestamp(System.currentTimeMillis()))
                .build();
            questionReplyRepo.save(questionReply);
            return questionReply;
        } else return null;
    }

    // read questionReply
    public QuestionReply readQuestionReply(Long id) {
        Optional<QuestionReply> optional = questionReplyRepo.findById(id);
        return optional.orElse(null);
    }

    //read allQuestionRepliesInfo
    public List<QuestionReply> readAllQuestionReplies() {
        Page<QuestionReply> page = questionReplyRepo.findAll(paging);
        if(page.hasContent()){
            return page.getContent();
        }
        return null;
    }

    //update questionReply
    public QuestionReply updateQuestionReply(Long questionReplyId, String content) {
        Optional<QuestionReply> optional = questionReplyRepo.findById(questionReplyId);
        if (optional.isPresent()) {
            QuestionReply questionReply = optional.get();
            questionReply = QuestionReply.builder()
                .content(content)
                .updateDate(new Timestamp(System.currentTimeMillis()))
                .build();
            questionReplyRepo.save(questionReply);
            return questionReply;
        } else return null;
    }

    // delete questionReply
    public boolean deleteQuestionReply(Long id) {
        Optional<QuestionReply> optional = questionReplyRepo.findById(id);
        if (optional.isPresent()) {
            questionReplyRepo.deleteById(optional.get().getId());
            Optional<QuestionReply> check = questionReplyRepo.findById(id);
            return !check.isPresent();
        }
        return false;
    }
}
