package com.shopcart.shopcart.entity;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@MappedSuperclass
public class baseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


}
