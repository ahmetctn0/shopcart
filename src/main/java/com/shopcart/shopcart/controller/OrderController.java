package com.shopcart.shopcart.controller;

import com.shopcart.shopcart.entity.Order;
import com.shopcart.shopcart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Order createOrder(@RequestParam int customerId) {
        return orderService.createOrderFromCart(customerId);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getAllOrdersByCustomerId(@PathVariable int customerId) {
        return orderService.getAllOrdersByCustomerId(customerId);
    }
}
