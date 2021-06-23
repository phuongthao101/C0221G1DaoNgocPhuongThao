package com.example.pa2_store_proceduce.model.service.impl;

import com.example.pa2_store_proceduce.model.entity.Customer;
import com.example.pa2_store_proceduce.model.repository.ICustomerRepository;
import com.example.pa2_store_proceduce.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public void insertCustomer(Customer customer) {
        customerRepository.insertCallCustomer(customer.getFirstName(),customer.getLastName());
    }
}
