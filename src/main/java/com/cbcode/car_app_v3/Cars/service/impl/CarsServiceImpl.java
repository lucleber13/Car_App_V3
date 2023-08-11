package com.cbcode.car_app_v3.Cars.service.impl;

import com.cbcode.car_app_v3.Cars.model.Car;
import com.cbcode.car_app_v3.Cars.model.DTO.NewCarDto;
import com.cbcode.car_app_v3.Cars.model.DTO.UsedCarDto;
import com.cbcode.car_app_v3.Cars.model.Enums.ConditionType;
import com.cbcode.car_app_v3.Cars.repository.CarsRepository;
import com.cbcode.car_app_v3.Cars.service.CarsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsServiceImpl implements CarsService {

    private final CarsRepository carsRepository;
    private final ModelMapper modelMapper;

    public CarsServiceImpl(CarsRepository carsRepository, ModelMapper modelMapper) {
        this.carsRepository = carsRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Car createCar(Car car) {
        checkCarStatus(car);
        return car;
    }

    private Car checkCarStatus(Car car) {
        Optional<Car> carsOptional = carsRepository.findCarByChassisNumber(car.getChassisNumber());
        Optional<Car> carsOptional1 = carsRepository.findCarByRegNumber(car.getRegNumber());
        if (carsOptional.isPresent() || carsOptional1.isPresent()) {
            throw new IllegalArgumentException("CarInfo with chassis number or reg number already exists");
        }
        if (car.getConditionType() == ConditionType.NEW) {
            NewCarDto newCarDto = modelMapper.map(car, NewCarDto.class);
            //newCarDto.setConditionType(ConditionType.NEW);
            return carsRepository.save(modelMapper.map(newCarDto, Car.class));
        } else if (car.getConditionType() == ConditionType.USED) {
            UsedCarDto usedCarDto = modelMapper.map(car, UsedCarDto.class);
            //usedCarDto.setConditionType(ConditionType.USED);
            return carsRepository.save(modelMapper.map(usedCarDto, Car.class));
        } else {
            throw new IllegalArgumentException("Invalid condition type");
        }

    }

    @Override
    public List<Car> getAllCars() {
        List<Car> carList = carsRepository.findAll();
        if (carList.isEmpty()) {
            throw new IllegalArgumentException("No cars found");
        }
        return carList;
    }

    @Override
    public Car getCarById(Long carId) {
       return carsRepository.findById(carId)
               .orElseThrow(() -> new IllegalArgumentException("CarInfo with id " + carId + " does not exist"));
    }

    @Override
    public Car updateUsedCar(Long carId, UsedCarDto usedCarDto) {
        return updateCar(carId, modelMapper.map(usedCarDto, Car.class));
    }

    @Override
    public Car updateNewCar(Long carId, NewCarDto newCarDto) {
      return updateCar(carId, modelMapper.map(newCarDto, Car.class));
    }

    @Override
    public Car updateCar(Long carId, Car updateCar) {
        Optional<Car> carsOptional = carsRepository.findById(carId);
        if (carsOptional.isPresent()) {
            Car carUpdate = carsOptional.get();

            Car updatedCarInstance = Car.builder()
                    .withModel(updateCar.getModel())
                    .withColor(updateCar.getColor())
                    .withCustomerName(updateCar.getCustomerName())
                    .withRegNumber(updateCar.getRegNumber())
                    .withChassisNumber(updateCar.getChassisNumber())
                    .withKeysNumber(updateCar.getKeysNumber())
                    .withMileage(updateCar.getMileage())
                    .withIsSold(updateCar.getIsSold())
                    .withDateArrived(updateCar.getDateArrived())
                    .withDateRequired(updateCar.getDateRequired())
                    .withConditionType(updateCar.getConditionType())
                    .build();

            updatedCarInstance.setCarId(carId);

            return carsRepository.save(updatedCarInstance);
        } else {

            throw new IllegalArgumentException("CarInfo with id " + carId + " does not exist");
        }
    }

    @Override
    public void deleteCar(Long id) {
        Optional<Car> carsOptional = carsRepository.findById(id);
        if (carsOptional.isEmpty()) {
            throw new IllegalArgumentException("CarInfo with id " + id + " does not exist");
        } else {
            carsRepository.deleteById(id);
        }
    }

    @Override
    public Car getCarByChassisNumber(String chassisNumber) {
        Optional<Car> carsOptional = carsRepository.findCarByChassisNumber(chassisNumber);
        if (carsOptional.isPresent()) {
            return carsOptional.get();
        }
        throw new IllegalArgumentException("CarInfo with chassis number " + chassisNumber + " does not exist");
    }

    @Override
    public Car getCarByRegNumber(String regNumber) {
        Optional<Car> carsOptional = carsRepository.findCarByRegNumber(regNumber);
        if (carsOptional.isPresent()) {
            return carsOptional.get();
        }
        throw new IllegalArgumentException("CarInfo with reg number " + regNumber + " does not exist");
    }

    @Override
    public List<Car> getCarByCustomerName(String customerName) {
        Optional<List<Car>> carsOptional = carsRepository.findCarByCustomerNameIgnoreCase(customerName);
        if (carsOptional.isPresent()) {
            return carsOptional.get();
        }
        throw new IllegalArgumentException("CarInfo with customer name " + customerName + " does not exist");
    }

    @Override
    public List<Car> getCarByModel(String model) {
        Optional<List<Car>> carsOptional = carsRepository.findCarByModelIgnoreCase(model);
        if (carsOptional.isPresent()) {
            return carsOptional.get();
        }
        throw new IllegalArgumentException("CarInfo with model " + model + " does not exist");
    }
}
