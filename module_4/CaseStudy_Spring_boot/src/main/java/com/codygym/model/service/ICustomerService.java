package com.codygym.model.service;

import com.codygym.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    Page<Customer> findByName(String name, Pageable pageable);

    void save(Customer customer);

    void remove(Long id);


}
