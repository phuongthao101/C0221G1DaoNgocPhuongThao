package com.codygym.model.service;

import com.codygym.model.entity.service.RentType;
import com.codygym.model.entity.service.Services;
import com.codygym.model.entity.service.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    void save(Services service);

    List<ServiceType> findAllServiceType();

    List<RentType> findAllRentType();

    Page<Services> findAllService(Pageable pageable);

}
