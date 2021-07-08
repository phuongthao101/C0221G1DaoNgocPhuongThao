package com.codygym.model.service;

import com.codygym.model.entity.customer.Customer;
import com.codygym.model.entity.customer.CustomerType;
import com.codygym.model.entity.employee.Division;
import com.codygym.model.entity.employee.EducationDegree;
import com.codygym.model.entity.employee.Employee;
import com.codygym.model.entity.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Employee findById(Long id);

    Page<Employee> findByName(String keyword, Pageable pageable);

    void save(Employee employee);

    void remove(Long id);

    List<Division> findAllDivision();
    List<EducationDegree> findAllEducationDegree();
    List<Position> findAllPosition();


}
