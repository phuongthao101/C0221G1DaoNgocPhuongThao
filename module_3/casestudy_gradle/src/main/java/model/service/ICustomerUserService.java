package model.service;

import model.bean.CustomerService.CustomerUsing;
import model.bean.CustomerService.ShowAttachService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ICustomerUserService {

    public List<CustomerUsing> findAllCustomerUsing();

    public List<CustomerUsing> findByName(String name);

    public boolean update(int id, CustomerUsing customerUsing) ;
    CustomerUsing findById(int id);

    boolean remove(int id);
    List<ShowAttachService> findAllAttach();
}
