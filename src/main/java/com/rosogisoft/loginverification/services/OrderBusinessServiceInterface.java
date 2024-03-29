package com.rosogisoft.loginverification.services;

import com.rosogisoft.loginverification.models.OrderModel;
import java.util.List;

public interface OrderBusinessServiceInterface {

    public List<OrderModel> getOrders();

    public void init();

    public void destroy();

    public OrderModel getById(Long id);

    public List<OrderModel> searchOrders(String searchTerm);

    public long addOne(OrderModel newOrder);

    public boolean deleteOne(Long id);

    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder);

}
