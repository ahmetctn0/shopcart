package com.shopcart.shopcart.service;

import com.shopcart.shopcart.entity.Cart;
import com.shopcart.shopcart.entity.Order;
import com.shopcart.shopcart.entity.Product;
import com.shopcart.shopcart.repository.OrderRepository;
import com.shopcart.shopcart.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CartService cartService, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.productRepository = productRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bu id'de sipariş yoktur: " + id));
    }

    @Override
    public List<Order> getAllOrdersByCustomerId(int customerId) {
        return orderRepository.findByCustomer_Id(customerId);
    }

    public Order createOrderFromCart(int customerId) {

        Cart cart = cartService.getCartByCustomerId(customerId);
        Map<Product, Integer> productQuantities = cart.getProductQuantities();

        Order order = new Order();
        order.setCustomer(cart.getCustomer());


        order.setProducts(new ArrayList<>(productQuantities.keySet()));
        order.setTotal(cart.getTotal());


        return orderRepository.save(order);
    }
}
