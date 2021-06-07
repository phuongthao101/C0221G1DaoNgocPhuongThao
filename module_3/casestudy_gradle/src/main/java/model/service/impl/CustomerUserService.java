package model.service.impl;

import model.bean.CustomerService.CustomerUsing;
import model.bean.CustomerService.ShowAttachService;
import model.repository.CustomerUsingRepository;
import model.service.ICustomerUserService;

import java.util.List;

public class CustomerUserService implements ICustomerUserService {

CustomerUsingRepository usingRepository = new CustomerUsingRepository();
    @Override
    public List<CustomerUsing> findAllCustomerUsing() {
        return usingRepository.findAllCustomerUsing();
    }

    @Override
    public List<CustomerUsing> findByName(String name) {
        return usingRepository.findByName(name);
    }

    @Override
    public boolean update(int id, CustomerUsing customerUsing) {
        return usingRepository.update(id,customerUsing);
    }

    @Override
    public CustomerUsing findById(int id) {
        return usingRepository.findById(id);
    }

    @Override
    public boolean remove(int id) {
        return usingRepository.remove(id);
    }

    @Override
    public List<ShowAttachService> findAllAttach() {
        return usingRepository.findAllAttach();
    }

}
