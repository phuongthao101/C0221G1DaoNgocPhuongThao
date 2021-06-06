package model.service.impl;

import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;
import model.repository.ServiceRepository;
import model.service.IService;

import java.util.List;

public class ServiceService implements IService {

    ServiceRepository userRepository = new ServiceRepository();
    @Override
    public List<ServiceType> findAllServiceType() {
        return userRepository.findAllServiceType();
    }

    @Override
    public List<RentType> findAllRentType() {
        return userRepository.findAllRentType();
    }

    @Override
    public List<Service> findAllService() {
        return userRepository.findAllService();
    }

    @Override
    public boolean create(Service service) {
        return userRepository.create(service);
    }



}
