package com.rosogisoft.loginverification.data;

import com.rosogisoft.loginverification.models.OrderModel;
import com.rosogisoft.loginverification.models.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrdersDataService implements OrderDataAccessInterface{

    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public OrderModel getById(Long id) {
        List<OrderModel> result = jdbcTemplate.query("SELECT * FROM ORDERS WHERE ID = ?", new OrdersMapper(), id);
        if (result.size() > 0){
            return result.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderModel> results =  jdbcTemplate.query("SELECT * FROM ORDERS;\n", new OrdersMapper());
        return results;
    }

    @Override
    public List<OrderModel> searchOrders(String searchTerm) {
        List<OrderModel> result = jdbcTemplate.query("SELECT * FROM ORDERS WHERE PRODUCT_NAME LIKE ?", new OrdersMapper(), "%" + searchTerm + "%");
        return result;
    }

    @Override
    public long addOne(OrderModel newOrder) {
//        long result = jdbcTemplate.update("INSERT INTO ORDERS (ORDER_NUMBER, PRODUCT_NAME, PRICE, QTY) VALUES (?, ?, ?, ?)",
//                newOrder.getOrderNo(),
//                newOrder.getProductName(),
//                newOrder.getPrice(),
//                newOrder.getQuantity());
//        return result;
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("ORDERS").usingGeneratedKeyColumns("ID");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("ORDER_NUMBER", newOrder.getOrderNo());
        param.put("PRODUCT_NAME", newOrder.getProductName());
        param.put("PRICE", newOrder.getPrice());
        param.put("QTY", newOrder.getQuantity());
        Number result = simpleJdbcInsert.executeAndReturnKey(param);

        return result.longValue();
    }

    @Override
    public boolean deleteOne(Long id) {
        int result = jdbcTemplate.update("DELETE FroM ORDERS WHERE ID = ?", id);
        if (result > 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public OrderModel updateOne(long idToUpdate, OrderModel updateOrder) {
        int result = jdbcTemplate.update("UPDATE ORDERS SET ORDER_NUMBER = ?, PRODUCT_NAME = ?, PRICE = ?, QTY = ? WHERE ID = ?",
                updateOrder.getOrderNo(),
                updateOrder.getProductName(),
                updateOrder.getPrice(),
                updateOrder.getQuantity(),
                idToUpdate);
        if (result > 0){
            return updateOrder;
        } else {
            return null;
        }

    }
}
