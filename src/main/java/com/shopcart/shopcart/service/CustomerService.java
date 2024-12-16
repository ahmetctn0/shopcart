package com.shopcart.shopcart.service;

import com.shopcart.shopcart.entity.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer saveCustomer(Customer customer);
    Customer getCustomerById(int id);
}
