package com.cbcode.car_app_v3.Cars.service;

import com.cbcode.car_app_v3.Cars.model.Cars;
import com.cbcode.car_app_v3.Cars.model.DTO.NewCarDto;
import com.cbcode.car_app_v3.Cars.model.DTO.UsedCarDto;

import java.util.List;

public interface CarsService {
    Cars createCar(Cars car);
    Cars getCarById(Long id);
    List<Cars> getAllCars();
    Cars updateCar(Long carId, Cars car);
    Cars updateUsedCar(UsedCarDto usedCarDto);
    Cars updateNewCar(Long carId, NewCarDto newCarDto);
    void deleteCar(Long id);
    Cars getCarByChassisNumber(String chassisNumber);
    Cars getCarByRegNumber(String regNumber);
    List<Cars> getCarByCustomerName(String customerName);
    Cars getCarByBrandAndModel(String brand, String model);

    Cars getCarBySold(Boolean sold);
}
