package model.service.impl;

import model.bean.contract.Contract;
import model.bean.customer.Customer;
import model.bean.employee.Employee;
import model.bean.service.Service;
import model.repository.ContractRepository;
import model.service.IContractService;

import java.util.List;

public class ContractService implements IContractService {
    ContractRepository userRepository = new ContractRepository();


    @Override
    public List<Employee> findAllEmployee() {
        return userRepository.findAllEmployee();
    }

    @Override
    public List<Customer> findByAll() {
        return userRepository.findByAll();
    }

    @Override
    public List<Service> findAllService() {
        return userRepository.findAllService();
    }

    @Override
    public List<Contract> findAllContract() {
        return userRepository.findAllContract();
    }

    @Override
    public boolean create(Contract contract) {
        return userRepository.create(contract);
    }


}
