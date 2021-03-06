package com.codygym.model.repository.customer;

import com.codygym.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository  extends JpaRepository<Customer, Long> {


    @Query(value = "select * from customer c where c.`name` like %?1% && c.flag=1", nativeQuery = true)
    Page<Customer> findByName(String keyword, Pageable pageable);


}
