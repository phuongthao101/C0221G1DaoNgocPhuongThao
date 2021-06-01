package model.service.impl;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    boolean update(User user) throws SQLException;

    User findById(int id);

    List<User> findByAll();

    boolean remove(int id) throws SQLException;

    boolean add(User user) throws SQLException;

    List<User> findByCountry(String country);

    List<User> sortByName();

    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;

    void addUserTransaction(User user, int[] permision);

    public void insertUpdateUseTransaction();

}
