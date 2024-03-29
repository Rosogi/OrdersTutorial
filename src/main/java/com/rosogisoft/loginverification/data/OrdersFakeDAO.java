package com.rosogisoft.loginverification.data;

import com.rosogisoft.loginverification.models.OrderModel;
import org.springframework.stereotype.Repository;

import java.rmi.NoSuchObjectException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrdersFakeDAO implements OrderDataAccessInterface{
    List<OrderModel> orders = new ArrayList<>();


    public OrdersFakeDAO() {
        orders.add(new OrderModel(0L, "000", "Sky diving experience", 1_500.0f, 1));
        orders.add(new OrderModel(1L, "001", "Fly to mars with Shad Sluiter", 2_500.0f, 2));
        orders.add(new OrderModel(2L, "002", "Go to college with proper education", 3_300.0f, 5));
        orders.add(new OrderModel(3L, "003", "Take a quick nap before work", 100.0f, 10));
        orders.add(new OrderModel(4L, "004", "Get job in big tech company like SberBank, Yandex, Microsoft, etc", 50_000.0f, 11));
        orders.add(new OrderModel(5L, "005", "Meet with the most beatific people in the world, like your fiends", 1_099.99f, 7));
        orders.add(new OrderModel(6L, "006", "Successfully run a tech company of your dream", 100_000.0f, 12));
        orders.add(new OrderModel(7L, "007", "Go to the beach with white sand, palms and banana-flavored daikiri", 12_000.0f, 99));
        orders.add(new OrderModel(8L, "008", "Work from home and never leave the \"man-cave\"", 1_499.99f, 13));
        orders.add(new OrderModel(9L, "009", "Be able to buy all thing that you want", 1_000_000.0f, 8));
        orders.add(new OrderModel(10L, "010", "Just be happy with life", 0.01f, 4));

    }


    @Override
    public OrderModel getById(Long id) {
        for (int i = 0; i < orders.size(); i++){
            if (orders.get(i).getId() == id){
                return orders.get(i);
            }
        }
        return null;
    }

    @Override
    public List<OrderModel> getOrders() {
        return orders;
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        List<OrderModel> foundItems = orders
                .stream()
                .filter(order -> order.getProductName().toLowerCase()
                        .contains(searchTerm.toLowerCase())).collect(Collectors.toList());

        return foundItems;
    }

    @Override
    public long addOne(OrderModel newOrder) {
        boolean succes = orders.add(newOrder);
        if (succes){
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public boolean deleteOne(Long id) {
        for (int i = 0; i < orders.size(); i++){
            if (orders.get(i).getId() == id){
                orders.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
        for (int i = 0; i < orders.size(); i++){
            if (orders.get(i).getId() == idToUpdate){
                orders.set(i, updateOrder);
                return orders.get(i);
            }
        }
        return null;
    }
}
