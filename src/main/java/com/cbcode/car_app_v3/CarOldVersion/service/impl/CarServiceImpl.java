package com.cbcode.car_app_v3.CarOldVersion.service.impl;

import com.cbcode.car_app_v3.CarOldVersion.Model.Car;
import com.cbcode.car_app_v3.CarOldVersion.Model.NewCar;
import com.cbcode.car_app_v3.CarOldVersion.Model.UsedCar;
import com.cbcode.car_app_v3.CarOldVersion.Repository.CarRepository;
import com.cbcode.car_app_v3.CarOldVersion.service.CarService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car createCar(Car car) {
        Optional<Car> carOptional;
        if (car instanceof NewCar) {
            carOptional = carRepository.findCarByChassisNumber(((NewCar) car).getChassisNumber());
        } else if (car instanceof UsedCar) {
            if (((UsedCar) car).getRegNumber() != null && !((UsedCar) car).getRegNumber().isEmpty()) {
                carOptional = carRepository.findCarByRegNumber(((UsedCar) car).getRegNumber());
            } else {
                carOptional = carRepository.findCarByChassisNumber(((UsedCar) car).getChassisNumber());
            }
        } else {
            carOptional = Optional.empty();
        }
        if (carOptional.isPresent()) {
            throw new IllegalStateException("CarOldVersion already exists");
        }
        return carRepository.save(car);
    }

    @Override
    public Car getCarById(Long id) {
        return null;
    }

    @Override
    public Car updateCar(Car car) {
        return null;
    }

    @Override
    public void deleteCar(Long id) {

    }

    @Override
    public Car getCarByChassisNumber(String chassisNumber) {
        return null;
    }

    @Override
    public Car getCarByRegNumber(String regNumber) {
        return null;
    }

    @Override
    public Car getCarByCustomerName(String customerName) {
        return null;
    }

    @Override
    public Car getCarByChassisNumberOrRegNumber(String chassisNumber, String regNumber) {
        return null;
    }

    @Override
    public Car getCarByBrandAndModel(String brand, String model) {
        return null;
    }

    @Override
    public Car getCarByDateArrivedOrDateRequired(String dateArrived, String dateRequired) {
        return null;
    }

    @Override
    public Car getCarBySold(Boolean sold) {
        return null;
    }
}
