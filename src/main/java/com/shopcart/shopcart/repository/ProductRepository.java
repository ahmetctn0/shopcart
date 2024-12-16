package com.shopcart.shopcart.repository;

import com.shopcart.shopcart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Integer>{
}
