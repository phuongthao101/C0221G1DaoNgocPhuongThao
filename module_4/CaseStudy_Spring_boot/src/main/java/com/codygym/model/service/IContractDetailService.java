package com.codygym.model.service;

import com.codygym.model.entity.contract.AttachService;
import com.codygym.model.entity.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {

    void save(ContractDetail contractDetail);
    Page<ContractDetail> findByContractId(Long id, Pageable pageable);
    List<AttachService> listAttachService();

}
