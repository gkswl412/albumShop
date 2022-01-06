package org.albumshop.controller.manager.delivery;


import lombok.extern.java.Log;
import org.albumshop.domain.Delivery;
import org.albumshop.service.manager.Delivery1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager/delivery/")
@Log
public class ManagerDeliveryController {

    @Autowired
    Delivery1Service delivery1Service;

    @GetMapping("/deliveryList")
    public void deliveryList(Model model){
/*        List<Delivery> deliveryList = deliveryService.readAllDeliveries();
        model.addAttribute("deliveryList", deliveryList);*/
        log.info("DeliveryList called...");
    }

    @GetMapping("/deliveryInfo")
    public void deliveryInfo(Long id, Model model){
        Delivery delivery = delivery1Service.readDelivery(1l);
        model.addAttribute("delivery", delivery);
        log.info("DeliveryId called...");
    }

}
