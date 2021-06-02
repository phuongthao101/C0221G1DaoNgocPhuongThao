package model.service;

import model.bean.Customer;
import model.repository.UserRepository;
import model.service.impl.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    UserRepository userRepository = new UserRepository();


    @Override
    public boolean update(Customer customer) {
        return userRepository.update(customer);
    }

    @Override
    public List<Customer> findByName(String name){
        return userRepository.findByName(name);
    }

    @Override
    public List<Customer> findByAll() {
        return userRepository.findByAll();
    }

    @Override
    public boolean remove(int id) {
        return userRepository.remove(id);
    }

    @Override
    public boolean add(Customer customer) {
        return userRepository.update(customer);
    }

    @Override
    public Customer findById(int id) {
        return null;
    }


}
