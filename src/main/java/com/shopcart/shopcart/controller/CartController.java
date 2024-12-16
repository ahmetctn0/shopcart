package com.shopcart.shopcart.controller;

import com.shopcart.shopcart.entity.Cart;
import com.shopcart.shopcart.entity.Product;
import com.shopcart.shopcart.service.CartService;
import com.shopcart.shopcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductRepository productRepository;

    @Autowired
    public CartController(CartService cartService, ProductRepository productRepository) {
        this.cartService = cartService;
        this.productRepository = productRepository;
    }

    @GetMapping("/{customerId}")
    public Cart getCart(@PathVariable int customerId) {
        return cartService.getCartByCustomerId(customerId);
    }

    @PutMapping("/update")
    public String updateCart(@RequestBody Cart cart) {
        cartService.updateCart(cart);
        return "Sepet güncellendi!";
    }

    @PostMapping("/{customerId}/add-product")
    public String addProductToCart(@PathVariable int customerId, @RequestParam int productId, @RequestParam int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı: " + productId));
        cartService.addProductToCart(customerId, product, quantity);
        return "Ürün sepete eklendi!";
    }

    @DeleteMapping("/{customerId}/remove-product")
    public String removeProductFromCart(@PathVariable int customerId, @RequestParam int productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı: " + productId));
        cartService.removeProductFromCart(customerId, product);
        return "Ürün sepetten silindi!";
    }

    @PutMapping("/{customerId}/update-product-quantity")
    public String updateProductQuantityInCart(@PathVariable int customerId, @RequestParam int productId, @RequestParam int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı: " + productId));
        cartService.updateProductQuantityInCart(customerId, product, quantity);
        return "Ürün miktarı güncellendi!";
    }
}
