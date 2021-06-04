package model.service.impl;

import model.bean.customer.Customer;
import model.bean.customer.TypeCustomer;
import model.repository.CustomerRepository;
import model.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    CustomerRepository userRepository = new CustomerRepository();


    @Override
    public boolean update(int id,Customer customer) {
        return userRepository.update(id,customer);
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
        return userRepository.add(customer);
    }

    @Override
    public Customer findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<TypeCustomer> findAllTypeCustomer() {
        return userRepository.findAllTypeCustomer();
    }

}
