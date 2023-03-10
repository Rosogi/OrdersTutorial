package com.rosogisoft.loginverification.services;

import com.rosogisoft.loginverification.models.OrderModel;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class OrderBusinessService2 implements OrderBusinessServiceInterface {
    List<OrderModel> orders;
    @Override
    public void test() {
        System.out.println("OrderBusinessService is working!");
    }

    @Override
    public List<OrderModel> getOrders() {


        orders.add(new OrderModel(0L, "AAA", "Big Mac", 3.0f, 1));
        orders.add(new OrderModel(1L, "AAB", "French fries", 2.50f, 1));
        orders.add(new OrderModel(2L, "AAC", "Hamburger", 2.0f, 1));
        orders.add(new OrderModel(3L, "AAD", "Pizza rolls", 2.99f, 3));
        orders.add(new OrderModel(4L, "AAE", "Taco", 5.45f, 1));
        orders.add(new OrderModel(5L, "AAF", "Burrito", 6.99f, 1));
        orders.add(new OrderModel(6L, "AAG", "Coke with ice", 2.50f, 1));
        orders.add(new OrderModel(7L, "AAH", "Dr. Pepper", 2.50f, 1));
        orders.add(new OrderModel(8L, "AAI", "Mountain Dew", 2.50f, 1));
        orders.add(new OrderModel(9L, "AAJ", "Soda", 2.0f, 1));

        return orders;
    }

    @Override
    public void init() {
        System.out.println("Init method of the OrderBusinessService 2");
        orders = new ArrayList<OrderModel>();
    }

    @Override
    public void destroy() {
        System.out.println("Destroy method of the OrderBusinessService 2");
    }
}
