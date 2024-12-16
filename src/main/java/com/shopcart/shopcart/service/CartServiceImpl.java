package com.shopcart.shopcart.service;

import com.shopcart.shopcart.entity.Cart;
import com.shopcart.shopcart.entity.Product;
import com.shopcart.shopcart.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart getCartByCustomerId(int customerId) {
        return cartRepository.findByCustomer_Id(customerId);
    }

    @Override
    public void updateCart(Cart cart) {
        cart.setTotal(calculateTotal(cart));
        cartRepository.save(cart);
    }

    @Override
    public void emptyCart(int customerId) {
        Cart cart = getCartByCustomerId(customerId);
        cart.getProductQuantities().clear();
        cart.setTotal(0);
        cartRepository.save(cart);
    }

    @Override
    public void addProductToCart(int customerId, Product product, int quantity) {
        Cart cart = getCartByCustomerId(customerId);
        Map<Product, Integer> productQuantities = cart.getProductQuantities();
        productQuantities.put(product, productQuantities.getOrDefault(product, 0) + quantity);
        cart.setTotal(calculateTotal(cart));
        cartRepository.save(cart);
    }

    @Override
    public void removeProductFromCart(int customerId, Product product) {
        Cart cart = getCartByCustomerId(customerId);
        Map<Product, Integer> productQuantities = cart.getProductQuantities();
        productQuantities.remove(product);
        cart.setTotal(calculateTotal(cart));
        cartRepository.save(cart);
    }

    @Override
    public void updateProductQuantityInCart(int customerId, Product product, int quantity) {
        Cart cart = getCartByCustomerId(customerId);
        Map<Product, Integer> productQuantities = cart.getProductQuantities();

        if (productQuantities.containsKey(product)) {
            productQuantities.put(product, quantity);
        }

        cart.setTotal(calculateTotal(cart));
        cartRepository.save(cart);
    }

    private double calculateTotal(Cart cart) {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : cart.getProductQuantities().entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            total += product.getPrice() * quantity;
        }
        return total;
    }
}
