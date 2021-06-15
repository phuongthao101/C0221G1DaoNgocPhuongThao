package model.service;

import model.bean.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IEmployeeService {
    List<Employee> findByAll();

    boolean update(int id, Employee employee);

    List<Employee> findByName(String name);

  List<String> create(Employee employee);

    boolean remove(int id);

    Employee findById(int id);
}
