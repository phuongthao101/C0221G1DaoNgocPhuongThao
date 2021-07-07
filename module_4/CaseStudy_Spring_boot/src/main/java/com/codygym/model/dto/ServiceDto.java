package com.codygym.model.dto;

import com.codygym.model.entity.service.RentType;
import com.codygym.model.entity.service.ServiceType;

public class ServiceDto {
    private  Long id;
    private  String serviceName;
    private  String serviceCode;
    private int serviceArea;
    private double serviceCost;
    private int serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private  double poolArea;
    private int numberOfFloors;
    private ServiceType serviceType;
    private RentType rentType;

    public ServiceDto() {
    }

    public ServiceDto(Long id, String serviceName, String serviceCode, int serviceArea, double serviceCost, int serviceMaxPeople, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloors, ServiceType serviceType, RentType rentType) {
        this.id = id;
        this.serviceName = serviceName;
        this.serviceCode = serviceCode;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.serviceType = serviceType;
        this.rentType = rentType;
    }

    public Long getId() {
        return id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }
}
