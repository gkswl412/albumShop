package org.albumshop.controller.manager.account;

import java.util.List;
import org.albumshop.domain.User;
import org.albumshop.persistence.UserRepository;
import org.albumshop.service.manager.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/account/")
@Log
public class ManagerAccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accountList")
    public void accountList(Model model){
        List<User> userList = accountService.readAllUsers();
        model.addAttribute("userList", userList);
        log.info("accountList called...");
    }

    @GetMapping("/accountInfo")
    public void accountId(String userId, Model model){
        User user = accountService.readUser("vvvvv");
        model.addAttribute("user", user);
        log.info("accountId called...");
    }
}
