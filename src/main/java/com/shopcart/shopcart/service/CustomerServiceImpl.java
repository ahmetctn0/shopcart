package com.shopcart.shopcart.service;

import com.shopcart.shopcart.entity.Customer;
import com.shopcart.shopcart.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bu id ile musteri bulunamadi: " + id));
    }
}
