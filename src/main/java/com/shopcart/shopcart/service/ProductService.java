package com.shopcart.shopcart.service;

import java.util.List;
import com.shopcart.shopcart.entity.Product;

public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(int id, Product product);
    Product saveProduct(Product product);
    void deleteProduct(int id);
    Product getProductById(int id);
    List<Product> getAllProducts();
}
