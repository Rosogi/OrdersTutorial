package com.rosogisoft.loginverification.controllers;

import com.rosogisoft.loginverification.models.OrderModel;
import com.rosogisoft.loginverification.services.OrderBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    OrderBusinessServiceInterface service;

    @Autowired
    public OrdersController(OrderBusinessServiceInterface service) {
        super();
        this.service = service;
    }

    @GetMapping("/")
    public String showAllOrders(Model model){
        List<OrderModel> orders = service.getOrders();

        model.addAttribute("title", "Here my dreams");
        model.addAttribute("orders", orders);

        return "orders.html";
    }
}
