package model.service;

import model.bean.contract.Contract;
import model.bean.customer.Customer;
import model.bean.employee.Employee;
import model.bean.service.Service;

import java.util.List;

public interface IContractService  {
    public List<Employee> findAllEmployee();

    public List<Customer> findByAll();

    public List<Service> findAllService();

    public List<Contract> findAllContract() ;

    boolean create(Contract contract);
}
