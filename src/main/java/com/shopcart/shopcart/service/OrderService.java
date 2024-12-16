package com.shopcart.shopcart.service;

import com.shopcart.shopcart.entity.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    Order getOrderById(int id);
    List<Order> getAllOrdersByCustomerId(int customerId);
    Order createOrderFromCart(int customerId);
}
