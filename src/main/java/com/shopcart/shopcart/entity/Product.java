package com.shopcart.shopcart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import com.shopcart.shopcart.entity.baseEntity;

@Entity
@Table(name="products")
public class Product extends baseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;
    private int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }
    public void setName(String name){

        this.name=name;
    }
    public double getPrice() {

        return price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public int getStock() {

        return stock;
    }
    public void setStock(int stock) {

        this.stock = stock;
    }

}
