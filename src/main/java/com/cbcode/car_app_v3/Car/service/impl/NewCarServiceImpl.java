package com.cbcode.car_app_v3.Car.service.impl;

import com.cbcode.car_app_v3.Car.Model.NewCar;
import com.cbcode.car_app_v3.Car.Repository.NewCarRepository;
import com.cbcode.car_app_v3.Car.service.NewCarService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class NewCarServiceImpl implements NewCarService {
    private final NewCarRepository newCarRepository;

    public NewCarServiceImpl(NewCarRepository newCarRepository) {
        this.newCarRepository = newCarRepository;
    }


    @Override
    public void addNewCar(NewCar newCar) {
        Optional<NewCar> newCarOptional = newCarRepository.findNewCarByChassisNumber(newCar.getChassisNumber());
        if (newCarOptional.isPresent()) {
            throw new IllegalStateException("Chassis number already exists");
        }
        NewCar newCar1 = new NewCar();
        newCar1.setChassisNumber(newCar.getChassisNumber());
        newCar1.setModel(newCar.getModel());
        newCar1.setBrand(newCar.getBrand());
        newCar1.setColor(newCar.getColor());
        newCar1.setDateArrived(newCar.getDateArrived());
        newCar1.setCustomerName(newCar.getCustomerName());
        newCar1.setKeysNumber(newCar.getKeysNumber());
        newCar1.setSold(newCar.getSold() != null && newCar.getSold());

        newCarRepository.save(newCar1);
    }

    @Override
    public void updateNewCar(NewCar newCar) {
        Optional<NewCar> newCarOptional = newCarRepository.findById(newCar.getCarId());
        if (newCarOptional.isEmpty()) {
            throw new IllegalStateException("New car with id " + newCar.getCarId() + " does not exist");
        }
        NewCar existingNewCar = newCarOptional.get();
        existingNewCar.setChassisNumber(newCar.getChassisNumber());
        existingNewCar.setModel(newCar.getModel());
        existingNewCar.setBrand(newCar.getBrand());
        existingNewCar.setColor(newCar.getColor());
        existingNewCar.setDateArrived(newCar.getDateArrived());
        existingNewCar.setCustomerName(newCar.getCustomerName());
        existingNewCar.setKeysNumber(newCar.getKeysNumber());
        existingNewCar.setSold(newCar.getSold() != null && newCar.getSold());

        newCarRepository.save(existingNewCar);
    }

    @Override
    public List<NewCar> getAllNewCars() {
        List<NewCar> newCarOptional = newCarRepository.findAll();
        if (newCarOptional.isEmpty()) {
            return Collections.emptyList();
        }
        return newCarOptional;

    }

    @Override
    public NewCar getNewCarById(long id) {
        Optional<NewCar> newCarOptional = newCarRepository.findById(id);
        if (newCarOptional.isPresent()) {
            return newCarOptional.get();
        } else {
            throw new IllegalStateException("New car with id " + id + " does not exist");
        }
    }

    @Override
    public void deleteNewCarById(long id) {
        Optional<NewCar> newCarOptional = newCarRepository.findById(id);
        if (newCarOptional.isPresent()) {
            newCarRepository.deleteById(id);
        } else {
            throw new IllegalStateException("New car with id " + id + " does not exist");
        }
    }


}
