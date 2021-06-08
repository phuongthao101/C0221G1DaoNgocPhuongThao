package model.service;

import model.bean.customer.Customer;
import model.bean.customer.TypeCustomer;

import java.util.List;

public interface ICustomerService {
    boolean update(int id, Customer customer) ;

     List<Customer> findByName(String name) ;

    List<Customer> findByAll();

    boolean remove(int id) ;

    List<String> add(Customer customer) ;

    Customer findById(int id);

    List<TypeCustomer> findAllTypeCustomer();

}
