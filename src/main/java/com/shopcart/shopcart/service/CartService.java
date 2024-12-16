package com.shopcart.shopcart.service;

import com.shopcart.shopcart.entity.Cart;
import com.shopcart.shopcart.entity.Product;

public interface CartService {
    Cart getCartByCustomerId(int customerId);
    void updateCart(Cart cart);
    void emptyCart(int customerId);
    void addProductToCart(int customerId, Product product, int quantity);
    void removeProductFromCart(int customerId, Product product);
    void updateProductQuantityInCart(int customerId, Product product, int quantity);
}
