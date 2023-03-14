package com.rosogisoft.loginverification.data;

import com.rosogisoft.loginverification.models.OrderModel;

import java.util.List;

public interface OrderDataAccessInterface {

    public OrderModel getById(Long id);
    public List<OrderModel> getOrders();
    public List<OrderModel> searchOrders(String searchTerm);
    public long addOne(OrderModel newOrder);
    public boolean deleteOne(Long id);
    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder);
}
