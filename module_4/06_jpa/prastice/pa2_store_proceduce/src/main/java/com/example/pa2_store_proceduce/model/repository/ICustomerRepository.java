package com.example.pa2_store_proceduce.model.repository;

import com.example.pa2_store_proceduce.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Procedure(procedureName = "Insert_Customer")
    void insertCallCustomer(String fist_name, String last_name);
}
