package com.rosogisoft.loginverification.services;

import com.rosogisoft.loginverification.models.OrderModel;
import java.util.List;

public interface OrderBusinessServiceInterface {

    public void test();

    public List<OrderModel> getOrders();

    public void init();

    public void destroy();

    //future list

    //searchOrders(String searchTerm)

    //addOrder(OrderModel newOrder)

    //deleteOrder(Long id)

    //updateOrder(OrderModel updateOrder)

    //getOneOrder(Long id)

}
