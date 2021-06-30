package com.codegym.controller;

import com.codegym.model.entity.Customer;
import com.codegym.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/customers"})
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping(value = "")
    public ResponseEntity<List<Customer>> findAllCustomer() {
        List<Customer> customerList = iCustomerService.findAll();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList,HttpStatus.OK);

    }

    @GetMapping("{/id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        Customer customer = iCustomerService.findById(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);


        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        this.iCustomerService.save(customer);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @PutMapping(value = "{/id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        Customer customer1 = this.iCustomerService.findById(id);
        if (customer1 == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{/id}")
    public ResponseEntity<Customer> deteleCustomer(@PathVariable Long id) {
        Customer customer = this.iCustomerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
