package com.example.demo.model.service;

import com.example.demo.model.entity.Customer;


import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);
}
