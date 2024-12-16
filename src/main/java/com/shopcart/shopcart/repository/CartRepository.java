package com.shopcart.shopcart.repository;

import com.shopcart.shopcart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Cart findByCustomer_Id(int customerId);
}


