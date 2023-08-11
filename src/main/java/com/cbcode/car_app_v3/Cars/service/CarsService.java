package com.cbcode.car_app_v3.Cars.service;

import com.cbcode.car_app_v3.Cars.model.Car;
import com.cbcode.car_app_v3.Cars.model.DTO.NewCarDto;
import com.cbcode.car_app_v3.Cars.model.DTO.UsedCarDto;

import java.util.List;

public interface CarsService {
    Car createCar(Car car);
    Car getCarById(Long id);
    List<Car> getAllCars();
    Car updateCar(Long carId, Car car);
    Car updateUsedCar(Long carId, UsedCarDto usedCarDto);
    Car updateNewCar(Long carId, NewCarDto newCarDto);
    void deleteCar(Long id);
    Car getCarByChassisNumber(String chassisNumber);
    Car getCarByRegNumber(String regNumber);
    List<Car> getCarByCustomerName(String customerName);
    List<Car> getCarByModel(String model);

}
