package com.cbcode.car_app_v3.Cars.model;

public class SoldCar {
    private Car car;
    private Boolean isNeedService;
    private Boolean isNeedMot;
    private Boolean isNeedPdi;
    private Boolean isNeedValeting;

    public SoldCar() {
        super();
    }

    public SoldCar(Car car, Boolean isNeedService, Boolean isNeedMot, Boolean isNeedPdi, Boolean isNeedValeting) {
        super( );
        this.car = car;
        this.isNeedService = isNeedService;
        this.isNeedMot = isNeedMot;
        this.isNeedPdi = isNeedPdi;
        this.isNeedValeting = isNeedValeting;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Boolean getNeedService() {
        return isNeedService;
    }

    public void setNeedService(Boolean needService) {
        isNeedService = needService;
    }

    public Boolean getNeedMot() {
        return isNeedMot;
    }

    public void setNeedMot(Boolean needMot) {
        isNeedMot = needMot;
    }

    public Boolean getNeedPdi() {
        return isNeedPdi;
    }

    public void setNeedPdi(Boolean needPdi) {
        isNeedPdi = needPdi;
    }

    public Boolean getNeedValeting() {
        return isNeedValeting;
    }

    public void setNeedValeting(Boolean needValeting) {
        isNeedValeting = needValeting;
    }
}
