package com.codygym.model.service.impl;

import com.codygym.model.entity.employee.Division;
import com.codygym.model.entity.employee.EducationDegree;
import com.codygym.model.entity.employee.Employee;
import com.codygym.model.entity.employee.Position;
import com.codygym.model.repository.employee.IDivisionRepository;
import com.codygym.model.repository.employee.IEducationDegreeRepository;
import com.codygym.model.repository.employee.IEmployeeRepository;
import com.codygym.model.repository.employee.IPositionRepository;
import com.codygym.model.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;
    @Autowired
    IDivisionRepository divisionRepository;
    @Autowired
    IEducationDegreeRepository educationDegreeRepository;
    @Autowired
    IPositionRepository positionRepository;
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable) ;
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Employee> findByName(String keyword, Pageable pageable) {
        return employeeRepository.findByName(keyword,pageable);
    }

    @Override
    public void save(Employee employee) {
employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {

        Employee employee=this.findById(id);
        employee.setFlag(false);
        save(employee);
    }

    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAll();
    }
}
