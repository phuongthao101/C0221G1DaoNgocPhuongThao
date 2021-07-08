package com.codygym.model.service.impl;

import com.codygym.model.entity.contract.AttachService;
import com.codygym.model.entity.contract.Contract;
import com.codygym.model.entity.contract.ContractDetail;
import com.codygym.model.repository.contract.IAttachServiceRepository;
import com.codygym.model.repository.contract.IContractDetailRepository;
import com.codygym.model.repository.contract.IContractRepository;
import com.codygym.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;
    @Autowired
    IContractDetailRepository contractDetailRepository;
    @Autowired
    IAttachServiceRepository attachServiceRepository;

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<AttachService> findAllAttachService() {
        return attachServiceRepository.findAll();
    }

    @Override
    public List<ContractDetail> findAllContractDetail() {
        return contractDetailRepository.findAll();
    }

    @Override
    public List<Contract> findAllContract() {
        return contractRepository.findAll();
    }
}
