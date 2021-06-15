package model.service;

import common.Validate;
import model.bean.Employee;
import model.repository.BaseRepository;
import model.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements IEmployeeService{

EmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> findByAll() {
        return employeeRepository.findByAll();
    }

    @Override
    public boolean update(int id, Employee employee) {
        return employeeRepository.update(id,employee);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public List<String> create(Employee employee) {
        List<String> validString = new ArrayList<>();
        validString.add(Validate.checkName(employee.getName()));

        int checkFull = 0;
        for (String string : validString ){
            if (string.equals("")){
                checkFull++;
            }
        }
        if (checkFull==1){
            employeeRepository.create(employee);
        }
        return validString;
    }


    @Override
    public boolean remove(int id) {
        return employeeRepository.remove(id);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }
}
