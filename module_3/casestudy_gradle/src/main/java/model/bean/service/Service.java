package model.bean.service;

public class Service {


    private int serviceId;
    private String name;
    private int area;
    private double serviceCost;
    private int maxPeople;
    private int rentTypeId;
    private int serviceTypeId;
    private String standardRoom;
    private String convenienceDescription;
    private String poolArea;
    private String numberFloors;

    public Service() {
    }

    public Service(int serviceId, String name, int area, double serviceCost, int maxPeople, int rentTypeId, int serviceTypeId, String standardRoom, String convenienceDescription, String poolArea, String numberFloors) {
        this.serviceId = serviceId;
        this.name = name;
        this.area = area;
        this.serviceCost = serviceCost;
        this.maxPeople = maxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.convenienceDescription = convenienceDescription;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public Service(String name, int area, double serviceCost, int maxPeople, int rentTypeId, int serviceTypeId, String standardRoom, String convenienceDescription, String poolArea, String numberFloors) {
        this.name = name;
        this.area = area;
        this.serviceCost = serviceCost;
        this.maxPeople = maxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.convenienceDescription = convenienceDescription;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getConvenienceDescription() {
        return convenienceDescription;
    }

    public void setConvenienceDescription(String convenienceDescription) {
        this.convenienceDescription = convenienceDescription;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(String numberFloors) {
        this.numberFloors = numberFloors;
    }
}
