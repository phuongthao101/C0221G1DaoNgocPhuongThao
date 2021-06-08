package model.service.impl;

import common.Validate;
import model.bean.customer.Customer;
import model.bean.customer.TypeCustomer;
import model.repository.CustomerRepository;
import model.service.ICustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {
    CustomerRepository userRepository = new CustomerRepository();


    @Override
    public boolean update(int id, Customer customer) {
        return userRepository.update(id, customer);
    }

    @Override
    public List<Customer> findByName(String name) {
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
    public List<String> add(Customer customer) {

        List<String> validString = new ArrayList<>();
        validString.add(Validate.checkName(customer.getName()));
        validString.add(Validate.checkDay(customer.getBirthday()));
        validString.add(Validate.checkIdCard(customer.getIdCard()));
        validString.add(Validate.checkPhoneNumber(customer.getPhone()));
        validString.add(Validate.checkEmail(customer.getEmail()));
        validString.add(Validate.checkName(customer.getAddress()));

        int checkFull = 0;
        for (String string : validString ){
            if (string.equals("")){
                checkFull++;
            }
        }
        if (checkFull==6){
             userRepository.add(customer);
        }
        return validString;
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
