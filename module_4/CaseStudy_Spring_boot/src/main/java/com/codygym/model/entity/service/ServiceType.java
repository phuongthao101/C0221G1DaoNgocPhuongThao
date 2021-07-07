package com.codygym.model.entity.service;

import javax.persistence.*;
import java.util.List;
@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceTypeId;
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    List<Services> serviceList;

    public List<Services> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Services> serviceList) {
        this.serviceList = serviceList;
    }

    public ServiceType() {
    }

    public ServiceType(Long serviceTypeId, String serviceTypeName, List<Services> serviceList) {
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
        this.serviceList = serviceList;
    }

    public Long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }
}
