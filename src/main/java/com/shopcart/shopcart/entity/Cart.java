package com.shopcart.shopcart.entity;

import jakarta.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "carts")
public class Cart extends baseEntity{

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ElementCollection
    @MapKeyJoinColumn(name = "product_id")
    @Column(name = "quantity")
    private Map<Product, Integer> productQuantities = new HashMap<>();

    private double total;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<Product, Integer> getProductQuantities() {
        return productQuantities;
    }

    public void setProductQuantities(Map<Product, Integer> productQuantities) {
        this.productQuantities = productQuantities;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
