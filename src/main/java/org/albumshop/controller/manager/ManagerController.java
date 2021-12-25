package org.albumshop.controller.manager;

import java.util.List;
import java.util.Optional;
import lombok.extern.java.Log;
import org.albumshop.domain.User;
import org.albumshop.persistence.UserRepository;
import org.albumshop.service.manager.AccountService;
import org.albumshop.vo.PageVO;
import org.albumshop.vo.TestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/")
@Log
public class ManagerController {

    @Autowired
    UserRepository userRepo;
    @Autowired
    AccountService accountService;

    Pageable paging = PageRequest.of(0, 10, Sort.Direction.DESC, "id");

    @GetMapping("/account/accountList")
    public void accountList(String userId, Model model){
        List<User> userList = accountService.readAllUsers();
        model.addAttribute("userList", userList);
        log.info("accountList called...");

    }

    @GetMapping("/accountId")
    public void list(String userId, Model model){
        User user = accountService.readUser("asdf11123");
        model.addAttribute("user", user);
        log.info("accountId called...");
        //return "templates/manger/main.html";
    }
}
