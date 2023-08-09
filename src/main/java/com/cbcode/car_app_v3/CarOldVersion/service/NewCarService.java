package com.cbcode.car_app_v3.CarOldVersion.service;

import com.cbcode.car_app_v3.CarOldVersion.Model.NewCar;

import java.util.List;

public interface NewCarService {
    void addNewCar(NewCar newCar);
    List<NewCar> getAllNewCars();
    NewCar getNewCarById(long id);
    void deleteNewCarById(long id);
    void updateNewCar(NewCar newCar);
}
