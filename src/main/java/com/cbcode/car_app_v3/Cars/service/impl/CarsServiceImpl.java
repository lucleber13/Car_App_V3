package com.cbcode.car_app_v3.Cars.service.impl;

import com.cbcode.car_app_v3.Cars.model.Cars;
import com.cbcode.car_app_v3.Cars.model.DTO.CarsDto;
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
    public Cars createCar(Cars car) {
        checkCarStatus(car);
        return car;
    }

    private Cars checkCarStatus(Cars car) {
        Optional<Cars> carsOptional = carsRepository.findCarByChassisNumber(car.getChassisNumber());
        Optional<Cars> carsOptional1 = carsRepository.findCarByRegNumber(car.getRegNumber());
        if (carsOptional.isPresent() || carsOptional1.isPresent()) {
            throw new IllegalArgumentException("Car with chassis number or reg number already exists");
        }
        if (car.getConditionType() == ConditionType.NEW) {
            NewCarDto newCarDto = modelMapper.map(car, NewCarDto.class);
            newCarDto.setConditionType(ConditionType.NEW);
            return carsRepository.save(modelMapper.map(newCarDto, Cars.class));
        } else if (car.getConditionType() == ConditionType.USED) {
            UsedCarDto usedCarDto = modelMapper.map(car, UsedCarDto.class);
            usedCarDto.setConditionType(ConditionType.USED);
            return carsRepository.save(modelMapper.map(usedCarDto, Cars.class));
        } else {
            throw new IllegalArgumentException("Invalid condition type");
        }

    }

    @Override
    public List<Cars> getAllCars() {
        List<Cars> carsList = carsRepository.findAll();
        if (carsList.isEmpty()) {
            throw new IllegalArgumentException("No cars found");
        }
        return carsList;
    }

    @Override
    public Cars getCarById(Long carId) {
       return carsRepository.findById(carId)
               .orElseThrow(() -> new IllegalArgumentException("Car with id " + carId + " does not exist"));
    }

    @Override
    public Cars updateUsedCar(UsedCarDto usedCarDto) {
        return null;
    }

    @Override
    public Cars updateNewCar(Long carId, NewCarDto newCarDto) {
      return updateCar(carId, modelMapper.map(newCarDto, Cars.class));
    }

    @Override
    public Cars updateCar(Long carId, Cars car) {
        Optional<Cars> carsOptional = carsRepository.findById(carId);
        if (carsOptional.isPresent()) {
            Cars carUpdate = carsOptional.get();
            carUpdate.setBrand(car.getBrand());
            carUpdate.setModel(car.getModel());
            carUpdate.setColor(car.getColor());
            carUpdate.setKeysNumber(car.getKeysNumber());
            carUpdate.setChassisNumber(car.getChassisNumber().toUpperCase()); // Added to upper case
            carUpdate.setRegNumber(car.getRegNumber().toUpperCase()); // Added to upper case
            carUpdate.setCustomerName(car.getCustomerName());
            carUpdate.setConditionType(car.getConditionType());
            carUpdate.setDateArrived(car.getDateArrived());
            carUpdate.setDateRequired(car.getDateRequired());
            carUpdate.setMileage(car.getMileage());
            carUpdate.setSold(car.getSold());
            carUpdate.setNeedPainting(car.getNeedPainting());
            carUpdate.setNeedService(car.getNeedService());
            carUpdate.setNeedCleaning(car.getNeedCleaning());
            carUpdate.setNeedMot(car.getNeedMot());

            return carsRepository.save(carUpdate);
        } else {

            throw new IllegalArgumentException("Car with id " + car.getCarId() + " does not exist");
        }
    }

    @Override
    public void deleteCar(Long id) {
        Optional<Cars> carsOptional = carsRepository.findById(id);
        if (carsOptional.isEmpty()) {
            throw new IllegalArgumentException("Car with id " + id + " does not exist");
        } else {
            carsRepository.deleteById(id);
        }
    }

    @Override
    public Cars getCarByChassisNumber(String chassisNumber) {
        Optional<Cars> carsOptional = carsRepository.findCarByChassisNumber(chassisNumber);
        if (carsOptional.isPresent()) {
            return carsOptional.get();
        }
        throw new IllegalArgumentException("Car with chassis number " + chassisNumber + " does not exist");
    }

    @Override
    public Cars getCarByRegNumber(String regNumber) {
        Optional<Cars> carsOptional = carsRepository.findCarByRegNumber(regNumber);
        if (carsOptional.isPresent()) {
            return carsOptional.get();
        }
        throw new IllegalArgumentException("Car with reg number " + regNumber + " does not exist");
    }

    @Override
    public List<Cars> getCarByCustomerName(String customerName) {
        Optional<List<Cars>> carsOptional = carsRepository.findCarByCustomerName(customerName);
        if (carsOptional.isPresent()) {
            return carsOptional.get();
        }
        throw new IllegalArgumentException("Car with customer name " + customerName + " does not exist");
    }

    @Override
    public Cars getCarByBrandAndModel(String brand, String model) {
        return null;
    }

    @Override
    public Cars getCarBySold(Boolean sold) {
        return null;
    }
}
