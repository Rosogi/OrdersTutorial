package com.rosogisoft.loginverification.services;

import com.rosogisoft.loginverification.data.OrderDataAccessInterface;
import com.rosogisoft.loginverification.data.OrdersFakeDAO;
import com.rosogisoft.loginverification.models.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class OrderBusinessService implements OrderBusinessServiceInterface {

    @Autowired
    OrderDataAccessInterface ordersDAO;

    @Override
    public void init() {
        System.out.println("Init method of the OrderBusinessService");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method of the OrderBusinessService1");
    }

    @Override
    public List<OrderModel> getOrders() {
        return ordersDAO.getOrders();
    }

    @Override
    public OrderModel getById(Long id) {
        return ordersDAO.getById(id);
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        return ordersDAO.searchOrders(searchTerm);
    }

    @Override
    public long addOne(OrderModel newOrder) {
        return ordersDAO.addOne(newOrder);
    }

    @Override
    public boolean deleteOne(Long id) {
        return ordersDAO.deleteOne(id);
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
        return ordersDAO.updateOne(idToUpdate, updateOrder);
    }
}
