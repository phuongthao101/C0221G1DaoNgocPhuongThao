package com.codygym.model.service.impl;

import com.codygym.model.entity.contract.AttachService;
import com.codygym.model.entity.contract.ContractDetail;
import com.codygym.model.repository.contract.IAttachServiceRepository;
import com.codygym.model.repository.contract.IContractDetailRepository;
import com.codygym.model.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Autowired
    private IAttachServiceRepository attachServiceRepository;

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public Page<ContractDetail> findByContractId(Long id, Pageable pageable) {
        return contractDetailRepository.findAllByContractId(id, pageable);
    }

    @Override
    public List<AttachService> listAttachService() {
        return attachServiceRepository.findAll();
    }
}
