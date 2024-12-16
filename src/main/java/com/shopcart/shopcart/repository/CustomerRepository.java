package com.shopcart.shopcart.repository;

import com.shopcart.shopcart.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
