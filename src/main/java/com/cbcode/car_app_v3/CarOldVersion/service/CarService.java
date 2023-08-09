package com.cbcode.car_app_v3.CarOldVersion.service;

import com.cbcode.car_app_v3.CarOldVersion.Model.Car;

public interface CarService {

    Car createCar(Car car);
    Car getCarById(Long id);
    Car updateCar(Car car);
    void deleteCar(Long id);
    Car getCarByChassisNumber(String chassisNumber);
    Car getCarByRegNumber(String regNumber);
    Car getCarByCustomerName(String customerName);
    Car getCarByChassisNumberOrRegNumber(String chassisNumber, String regNumber);
    Car getCarByBrandAndModel(String brand, String model);
    Car getCarByDateArrivedOrDateRequired(String dateArrived, String dateRequired);
    Car getCarBySold(Boolean sold);
}
