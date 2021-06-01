package model.service;

import model.bean.User;
import model.repository.UserRepository;
import model.service.impl.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    UserRepository userRepository = new UserRepository();


    @Override
    public boolean update(User user) throws SQLException {
        return userRepository.update(user);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findByAll() {
        return userRepository.findByAll();
    }

    @Override
    public boolean remove(int id) throws SQLException {
        return userRepository.remove(id);
    }

    @Override
    public boolean add(User user) {
        return userRepository.add(user);
    }

    @Override
    public List<User> findByCountry(String country) {
        return userRepository.findByCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return userRepository.sortByName();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) {
        userRepository.insertUserStore(user);

    }

    @Override
    public void addUserTransaction(User user, int[] permision) {

        userRepository.addUserTransaction(user, permision);
    }

    @Override
    public void insertUpdateUseTransaction() {
        userRepository.insertUpdateUseTransaction();
    }


}
