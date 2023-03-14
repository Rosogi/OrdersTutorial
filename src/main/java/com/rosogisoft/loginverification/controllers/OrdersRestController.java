package com.rosogisoft.loginverification.controllers;

import com.rosogisoft.loginverification.models.OrderModel;
import com.rosogisoft.loginverification.services.OrderBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersRestController {

    OrderBusinessServiceInterface service;

    @Autowired
    public OrdersRestController(OrderBusinessServiceInterface service) {
        super();
        this.service = service;
    }

    @GetMapping("/")
    public List<OrderModel> showAllOrders(Model model){
        List<OrderModel> orders = service.getOrders();

        return orders;
    }

    @GetMapping("/search/{searchTerm}")
    public List<OrderModel> searchOrders(@PathVariable(name = "searchTerm") String searchTerm){
        List<OrderModel> orders = service.searchOrders(searchTerm);

        return orders;
    }

    @PostMapping("/")
    public long addOrder(@RequestBody OrderModel model) {
        return service.addOne(model);
    }

    @GetMapping("/{id}")
    public OrderModel getById(@PathVariable(name = "id") long id){
        return service.getById(id);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteOne(@PathVariable(name = "id") long id){
        return service.deleteOne(id);
    }

    @PutMapping("/update/{id}")
    public OrderModel addOrder(@RequestBody OrderModel model, @PathVariable(name = "id") long id) {
        return service.updateOne(id, model);
    }
}
