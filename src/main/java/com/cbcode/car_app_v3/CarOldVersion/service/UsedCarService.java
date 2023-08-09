package com.cbcode.car_app_v3.CarOldVersion.service;

import com.cbcode.car_app_v3.CarOldVersion.Model.UsedCar;

import java.util.List;

public interface UsedCarService {

    void addUsedCar(UsedCar usedCar);
    List<UsedCar> getAllUsedCars();
    UsedCar getUsedCarById(long id);
    void deleteUsedCarById(long id);
    void updateUsedCar(UsedCar usedCar);
}
