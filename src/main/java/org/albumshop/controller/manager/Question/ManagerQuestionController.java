package org.albumshop.controller.manager.Question;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.java.Log;
import org.albumshop.domain.Question;
import org.albumshop.service.manager.QnAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/QnA/")
@Log
public class ManagerQuestionController {

    @Autowired
    QnAService qnAService;

    @GetMapping("/QnAList")
    public void QuestionList(Long questionId, Model model){
        List<Question> QuestionList = new ArrayList<>();
        QuestionList.add((qnAService.readQuestion(questionId)));
        model.addAttribute("QuestionList", QuestionList);
        log.info("qnAList called...");
    }

    @GetMapping("/QuestionInfo")
    public void QuestionInfo(Long id, Model model){
        Question Question = qnAService.readQuestion(1l);
        model.addAttribute("Question", Question);
        log.info("qnAId called...");
    }
}
