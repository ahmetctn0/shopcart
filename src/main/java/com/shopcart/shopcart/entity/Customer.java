package com.shopcart.shopcart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name="customers")
public class Customer extends baseEntity {

    private String name;
    private String Surname;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return Surname;
    }
    public void setSurname(String surname) {
        this.Surname = surname;
    }


}
