package com.example.pa1_customer_management.model.service;

import com.example.pa1_customer_management.model.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
