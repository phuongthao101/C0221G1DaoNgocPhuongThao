package model.service.impl;

import model.bean.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ICustomerService {
    boolean update(Customer customer) ;

     List<Customer> findByName(String name) ;

    List<Customer> findByAll();

    boolean remove(int id) ;

    boolean add(Customer customer) ;

}
