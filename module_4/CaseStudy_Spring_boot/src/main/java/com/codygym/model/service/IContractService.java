package com.codygym.model.service;

import com.codygym.model.entity.contract.AttachService;
import com.codygym.model.entity.contract.Contract;
import com.codygym.model.entity.contract.ContractDetail;

import java.util.List;

public interface IContractService {
   void save(Contract contract);

   List<AttachService> findAllAttachService();

   List<ContractDetail> findAllContractDetail();

   List<Contract> findAllContract();

}
