package model.service.impl;

import model.bean.employee.Division;
import model.bean.employee.EducationDegree;
import model.bean.employee.Employee;
import model.bean.employee.Position;
import model.repository.EmployeeRepository;
import model.service.IEmploymentService;

import java.util.List;

public class EmployeeService implements IEmploymentService {

    EmployeeRepository userRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAllEmployee() {
        return userRepository.findAllEmployee();
    }

    @Override
    public List<Position> findAllPosition() {
        return userRepository.findAllPosition();
    }

    @Override
    public List<EducationDegree> findAllEducation() {
        return userRepository.findAllEducation();
    }

    @Override
    public List<Division> findAllDivision() {
        return userRepository.findAllDivision();
    }

    @Override
    public boolean create(Employee employee) {
        return userRepository.create(employee);
    }

    @Override
    public boolean remove(int id) {
        return userRepository.remove(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public boolean update(int id, Employee employee) {
        return userRepository.update(id,employee);
    }

    @Override
    public Employee findById(int id) {
        return userRepository.findById(id);
    }

}
