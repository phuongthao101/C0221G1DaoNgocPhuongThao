package com.codygym.model.service.impl;

import com.codygym.model.entity.customer.Customer;
import com.codygym.model.entity.customer.CustomerType;
import com.codygym.model.repository.customer.ICustomerRepository;
import com.codygym.model.repository.customer.ICustomerTypeRepository;
import com.codygym.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;
    @Autowired
    ICustomerTypeRepository customerTypeRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findByName(String keyword, Pageable pageable) {
        return customerRepository.findByName(keyword, pageable);
    }

    @Override
    public void save(Customer customer) {

        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {

        Customer customer=this.findById(id);
        customer.setFlag(false);
        save(customer);
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }
}
