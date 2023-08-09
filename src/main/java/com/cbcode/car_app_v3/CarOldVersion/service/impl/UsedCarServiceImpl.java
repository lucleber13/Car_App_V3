package com.cbcode.car_app_v3.CarOldVersion.service.impl;

import com.cbcode.car_app_v3.CarOldVersion.Model.UsedCar;
import com.cbcode.car_app_v3.CarOldVersion.Repository.UsedCarRepository;
import com.cbcode.car_app_v3.CarOldVersion.service.UsedCarService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UsedCarServiceImpl implements UsedCarService {

    private final UsedCarRepository usedCarRepository;

    public UsedCarServiceImpl(UsedCarRepository usedCarRepository) {
        this.usedCarRepository = usedCarRepository;
    }


    @Override
    public void addUsedCar(UsedCar usedCar) {
        Optional<UsedCar> usedCarOptional = usedCarRepository.findUsedCarByChassisNumberOrRegNumber(usedCar.getChassisNumber(),usedCar.getRegNumber());
        if (usedCarOptional.isPresent()) {
            throw new IllegalStateException("CarOldVersion already exists in the database");
        }
        UsedCar usedCar1 = new UsedCar();
        usedCar1.setRegNumber(usedCar.getRegNumber());
        usedCar1.setModel(usedCar.getModel());
        usedCar1.setBrand(usedCar.getBrand());
        usedCar1.setColor(usedCar.getColor());
        usedCar1.setDateArrived(usedCar.getDateArrived());
        usedCar1.setMileage(usedCar.getMileage());
        usedCar1.setKeysNumber(usedCar.getKeysNumber());
        usedCar1.setChassisNumber(usedCar.getChassisNumber());
        usedCar1.setNeedsService(usedCar.getNeedsService() != null && usedCar.getNeedsService());
        usedCar1.setNeedsMOT(usedCar.getNeedsMOT() != null && usedCar.getNeedsMOT());
        usedCar1.setNeedsPaint(usedCar.getNeedsPaint() != null && usedCar.getNeedsPaint());
        usedCar1.setNeedsValet(usedCar.getNeedsValet() != null && usedCar.getNeedsValet());

        usedCarRepository.save(usedCar1);
    }

    @Override
    public List<UsedCar> getAllUsedCars() {
        List<UsedCar> usedCars = usedCarRepository.findAll();
        if (usedCars.isEmpty()) {
            return Collections.emptyList();
        }
        return usedCars;
    }

    @Override
    public UsedCar getUsedCarById(long id) {
        Optional<UsedCar> usedCarOptional = usedCarRepository.findById(id);
        if (usedCarOptional.isEmpty()) {
            throw new IllegalStateException("Used car with id " + id + " does not exist");
        }
        return usedCarOptional.get();
    }

    @Override
    public void deleteUsedCarById(long id) {
        Optional<UsedCar> usedCarOptional = usedCarRepository.findById(id);
        if (usedCarOptional.isEmpty()) {
            throw new IllegalStateException("Used car with id " + id + " does not exist");
        }
        usedCarRepository.deleteById(id);
    }

    @Override
    public void updateUsedCar(UsedCar usedCar) {
        Optional<UsedCar> usedCarOptional = usedCarRepository.findById(usedCar.getCarId());
        if (usedCarOptional.isEmpty()) {
            throw new IllegalStateException("Used car with id " + usedCar.getCarId() + " does not exist");
        }
        UsedCar usedCar1 = usedCarOptional.get();
        usedCar1.setRegNumber(usedCar.getRegNumber());
        usedCar1.setModel(usedCar.getModel());
        usedCar1.setBrand(usedCar.getBrand());
        usedCar1.setColor(usedCar.getColor());
        usedCar1.setDateArrived(usedCar.getDateArrived());
        usedCar1.setMileage(usedCar.getMileage());
        usedCar1.setKeysNumber(usedCar.getKeysNumber());
        usedCar1.setChassisNumber(usedCar.getChassisNumber());
        usedCar1.setNeedsService(usedCar.getNeedsService() != null && usedCar.getNeedsService());
        usedCar1.setNeedsMOT(usedCar.getNeedsMOT() != null && usedCar.getNeedsMOT());
        usedCar1.setNeedsPaint(usedCar.getNeedsPaint() != null && usedCar.getNeedsPaint());
        usedCar1.setNeedsValet(usedCar.getNeedsValet() != null && usedCar.getNeedsValet());

        usedCarRepository.save(usedCar1);
    }
}
