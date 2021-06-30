package com.codegym.model.service;

import com.codegym.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();


    Page<Customer> findAll(Pageable pageable);


    Customer findById(Long id);


    void save(Customer customer);


    void remove(Long id);

}
