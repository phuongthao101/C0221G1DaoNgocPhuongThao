package model.service.impl;

import model.bean.contract.AttachService;
import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;
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

    @Override
    public List<ContractDetail> findAllContractDetail() {
        return userRepository.findAllContractDetail();
    }

    @Override
    public List<AttachService> findAllAttachService() {
        return userRepository.findAllAttachService();
    }

    @Override
    public boolean create(ContractDetail contractDetail) {
        return userRepository.create(contractDetail);
    }

    @Override
    public Contract findAllContractId(int idContract) {
        return userRepository.findAllContractId(idContract);
    }

    @Override
    public boolean update(int id, Contract contract) {
        return userRepository.update(id,contract);
    }

}
