package org.albumshop.controller.manager;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
@Log
public class SampleController {

    @GetMapping("/list")
    public void list(){
        log.info("list() called...");
    }
}
