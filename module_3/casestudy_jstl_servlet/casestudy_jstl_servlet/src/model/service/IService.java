package model.service;

import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;

import java.util.List;

public interface IService {
    List<ServiceType> findAllServiceType();
    List<RentType> findAllRentType();
    List<Service> findAllService();
    boolean create(Service service);
}
