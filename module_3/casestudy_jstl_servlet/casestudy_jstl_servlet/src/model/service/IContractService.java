package model.service;

import model.bean.contract.Contract;
import model.bean.customer.Customer;
import model.bean.employee.Employee;
import model.bean.service.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IContractService  {
    public List<Employee> findAllEmployee();

    public List<Customer> findByAll();

    public List<Service> findAllService();

    public List<Contract> findAllContract() ;
}
