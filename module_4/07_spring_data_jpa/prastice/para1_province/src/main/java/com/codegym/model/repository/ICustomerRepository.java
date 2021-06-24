package com.codegym.model.repository;

import com.codegym.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    @Query(value = "select * from customers where first_name like :keywordParam",nativeQuery = true)
    Page<Customer> getCustomerBySearchingName(Pageable pageable, @Param("keywordParam") String keyword);
}
