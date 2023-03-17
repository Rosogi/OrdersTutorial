package com.rosogisoft.loginverification.controllers;

import com.rosogisoft.loginverification.models.OrderModel;
import com.rosogisoft.loginverification.models.SearchModel;
import com.rosogisoft.loginverification.services.OrderBusinessServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    OrderBusinessServiceInterface service;

    @Autowired
    public OrdersController(OrderBusinessServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showAllOrders(Model model){
        List<OrderModel> orders = service.getOrders();

        model.addAttribute("title", "Here my dreams");
        model.addAttribute("orders", orders);

        return "orders.html";
    }
    @PostMapping("/addNew")
    public String addNew(@Valid OrderModel newOrder, BindingResult bindingResult, Model model){
        service.addOne(newOrder);

        List<OrderModel> orders = service.getOrders();

        //model.addAttribute("title", "Here my dreams");
        model.addAttribute("orders", orders);

        return "orders.html";
    }
    @GetMapping("/showNewOrderForm")
    public String showNewForm(Model model){
        model.addAttribute("order", new OrderModel());
        return "addNewOrderForm.html";
    }

    @GetMapping("/showSearchTerm")
    public String showSearchTerm(Model model){
        model.addAttribute("searchModel", new SearchModel());
        return "searchForm.html";
    }

    @PostMapping("/search")
    public String search(@Valid SearchModel searchModel, BindingResult bindingResult, Model model){
        String searchTerm = searchModel.getSearchTerm();
        List<OrderModel> orders = service.searchOrders(searchTerm);
        model.addAttribute("orders", orders);
        return "orders.html";
    }

    @GetMapping("/admin")
    public String showAdminForm(Model model){
        List<OrderModel> orders = service.getOrders();

        model.addAttribute("title", "Here my dreams");
        model.addAttribute("orders", orders);

        return "ordersAdmin.html";
    }

    @PostMapping("/editForm")
    public String displayEditForm(OrderModel orderModel, Model model){
        model.addAttribute("title", "Edit order");
        model.addAttribute("orderModel", orderModel);
        return "editForm.html";
    }

    @PostMapping("/doUpdate")
    public String updateOrder(@Valid OrderModel order, BindingResult bindingResult, Model model){
        service.updateOne(order.getId(), order);
        List<OrderModel> orders = service.getOrders();
        model.addAttribute("orders", orders);

        return "ordersAdmin.html";
    }

    @PostMapping("/delete")
    public String deleteOrder(@Valid OrderModel order, BindingResult bindingResult, Model model){
        service.deleteOne(order.getId());
        List<OrderModel> orders = service.getOrders();

        model.addAttribute("orders", orders);
        model.addAttribute("");
        return "ordersAdmin.html";
    }
}
