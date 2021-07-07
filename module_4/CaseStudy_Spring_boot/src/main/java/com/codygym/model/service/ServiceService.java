package com.codygym.model.service;

import com.codygym.model.entity.service.RentType;
import com.codygym.model.entity.service.ServiceType;
import com.codygym.model.entity.service.Services;
import com.codygym.model.repository.service.IRentTypeRepository;
import com.codygym.model.repository.service.IServiceRepository;
import com.codygym.model.repository.service.IServiceTypeRepository;
import com.codygym.model.service.impl.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {
    @Autowired
    IServiceRepository serviceRepository;
    @Autowired
    IRentTypeRepository rentTypeRepository;
    @Autowired
    IServiceTypeRepository serviceTypeRepository;

    @Override
    public void save(Services service) {
      serviceRepository.save(service);

    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepository.findAll();
    }

    @Override
    public Page<Services> findAllService(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }
}
