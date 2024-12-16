package com.shopcart.shopcart.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order extends baseEntity {

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name="order_products",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private List<Product> products = new ArrayList<>();

    private double total;

    public Order() {

        this.total = 0.0;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public void calculateTotal() {
        double totalAmount = 0;
        for (Product product : products) {
            totalAmount += product.getPrice();
        }
        this.total = totalAmount;
    }
}
