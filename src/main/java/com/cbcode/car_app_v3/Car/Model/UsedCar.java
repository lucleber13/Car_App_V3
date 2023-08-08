package com.cbcode.car_app_v3.Car.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "used_cars")
@PrimaryKeyJoinColumn(name = "carId")
public class UsedCar extends Car{
    @Column(nullable = false, unique = true)
    private String regNumber;
    @Column(nullable = true, unique = true)
    private String chassisNumber;
    @Column(nullable = true)
    private Boolean isNeedsValet;
    @Column(nullable = true)
    private Boolean isNeedsService;
    @Column(nullable = true)
    private Boolean isNeedsMOT;
    @Column(nullable = true)
    private Boolean isNeedsPaint;
    @Column(nullable = false)
    private Integer mileage;

    public UsedCar() {
    }

    public UsedCar(String brand, String model, String color, Integer keysNumber, String regNumber,
                   Boolean isStock, Boolean isNeedsValet, Boolean isNeedsService, Boolean isNeedsMOT,
                   String chassisNumber, Boolean isNeedsPaint, Integer mileage) {
        super(brand, model, color, keysNumber);
        this.regNumber = regNumber;
        this.chassisNumber = chassisNumber;
        this.isNeedsValet = isNeedsValet;
        this.isNeedsService = isNeedsService;
        this.isNeedsMOT = isNeedsMOT;
        this.isNeedsPaint = isNeedsPaint;
        this.mileage = mileage;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public Boolean getNeedsValet() {
        return isNeedsValet;
    }

    public void setNeedsValet(Boolean needsValet) {
        isNeedsValet = needsValet;
    }

    public Boolean getNeedsService() {
        return isNeedsService;
    }

    public void setNeedsService(Boolean needsService) {
        isNeedsService = needsService;
    }

    public Boolean getNeedsMOT() {
        return isNeedsMOT;
    }

    public void setNeedsMOT(Boolean needsMOT) {
        isNeedsMOT = needsMOT;
    }

    public Boolean getNeedsPaint() {
        return isNeedsPaint;
    }

    public void setNeedsPaint(Boolean needsPaint) {
        isNeedsPaint = needsPaint;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }
}
