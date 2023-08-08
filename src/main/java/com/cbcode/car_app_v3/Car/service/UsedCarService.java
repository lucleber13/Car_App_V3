package com.cbcode.car_app_v3.Car.service;

import com.cbcode.car_app_v3.Car.Model.NewCar;
import com.cbcode.car_app_v3.Car.Model.UsedCar;

import java.util.List;

public interface UsedCarService {

    void addUsedCar(UsedCar usedCar);
    List<UsedCar> getAllUsedCars();
    UsedCar getUsedCarById(long id);
    void deleteUsedCarById(long id);
    void updateUsedCar(UsedCar usedCar);
}
