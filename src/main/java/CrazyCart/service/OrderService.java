package CrazyCart.service;

import CrazyCart.entity.Orders;

import java.util.List;

public interface OrderService {
    void placeOrder(String username);
    List<Orders> getOrdersByUsername(String username);
}
