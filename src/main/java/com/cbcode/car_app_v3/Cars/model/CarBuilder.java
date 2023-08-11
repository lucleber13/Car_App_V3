package com.cbcode.car_app_v3.Cars.model;

import com.cbcode.car_app_v3.Cars.model.Enums.ConditionType;

import java.util.Date;

public class CarBuilder {

    private String model;
    private String color;
    private String customerName;
    private String regNumber;
    private String chassisNumber;
    private Integer keysNumber;
    private Integer mileage;
    private Boolean isSold;
    private Date dateArrived;
    private Date dateRequired;
    private ConditionType conditionType;

    public CarBuilder withModel(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder withColor(String color) {
        this.color = color;
        return this;
    }

    public CarBuilder withCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public CarBuilder withRegNumber(String regNumber) {
        this.regNumber = regNumber.toUpperCase();
        return this;
    }

    public CarBuilder withChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
        return this;
    }

    public CarBuilder withKeysNumber(Integer keysNumber) {
        this.keysNumber = keysNumber;
        return this;
    }

    public CarBuilder withMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public CarBuilder withIsSold(Boolean isSold) {
        this.isSold = isSold;
        return this;
    }

    public CarBuilder withDateArrived(Date dateArrived) {
        this.dateArrived = dateArrived;
        return this;
    }

    public CarBuilder withDateRequired(Date dateRequired) {
        this.dateRequired = dateRequired;
        return this;
    }

    public CarBuilder withConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
        return this;
    }

    public Car build() {
        Car car = new Car();
        car.setModel(model);
        car.setColor(color);
        car.setCustomerName(customerName);
        car.setRegNumber(regNumber);
        car.setChassisNumber(chassisNumber);
        car.setKeysNumber(keysNumber);
        car.setMileage(mileage);
        car.setIsSold(isSold);
        car.setDateArrived(dateArrived);
        car.setDateRequired(dateRequired);
        car.setConditionType(conditionType);
        return car;
    }
}

