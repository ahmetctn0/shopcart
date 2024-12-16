package com.shopcart.shopcart.repository;

import com.shopcart.shopcart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomer_Id(int customerId);
}
