package model.service;

import model.bean.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    List<Product> findByAll();
    boolean add(Product product);
    List<Product> findByName(String name);
    public boolean remove(int id) ;
    public boolean update(int id, Product product);

    public Product findById(int id);
}
