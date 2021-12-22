package org.albumshop.controller.manager;


import lombok.extern.java.Log;
import org.albumshop.domain.Delivery;
import org.albumshop.persistence.CartDetailRepository;
import org.albumshop.persistence.CartRepository;
import org.albumshop.persistence.DeliveryRepository;
import org.albumshop.persistence.UserRepository;
import org.albumshop.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template/manager/")
@Log
public class ManagerDeliveryController {
    @Autowired
    DeliveryRepository deliRepo;

//    @GetMapping("/delivery")
//    public void list(
//        @PageableDefault(
//            direction = Sort.Direction.DESC,
//            sort = "id",
//            size = 10,
//            page = 0) Pageable page){
//        log.info("list() called" + page);
//    }

    @GetMapping("/delivery")
    public void list(PageVO vo, Model model){
        Pageable page = vo.makePaging(0, "id");

        Page<Delivery> result = deliRepo.findAll(page);
        log.info("" + page);
        log.info("" + result);

        model.addAttribute("result", result);
    }

}
