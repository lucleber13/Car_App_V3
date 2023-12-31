package com.cbcode.car_app_v3.Cars.controller;

import com.cbcode.car_app_v3.Cars.model.Car;
import com.cbcode.car_app_v3.Cars.model.DTO.CarDto;
import com.cbcode.car_app_v3.Cars.model.DTO.NewCarDto;
import com.cbcode.car_app_v3.Cars.model.DTO.UsedCarDto;
import com.cbcode.car_app_v3.Cars.service.CarsService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarsController {

    private final CarsService carsService;
    private final ModelMapper modelMapper;

    public CarsController(CarsService carsService, ModelMapper modelMapper) {
        this.carsService = carsService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/new")
    public void createNewCar(@RequestBody NewCarDto newCarDto) {
        Car newCar = modelMapper.map(newCarDto, Car.class);
        carsService.createCar(newCar);
    }

    @PostMapping("/used")
    public void createUsedCar(@RequestBody UsedCarDto usedCarDto) {
        Car newCar = modelMapper.map(usedCarDto, Car.class);
        carsService.createCar(newCar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carsService.getCarById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carsService.getAllCars());
    }

    @PutMapping("/update/used/{carId}")
    public ResponseEntity<Car> updateUsedCar(@PathVariable Long carId, @RequestBody UsedCarDto usedCarDto) {
        return ResponseEntity.ok(carsService.updateUsedCar(carId, usedCarDto));
    }

    @PutMapping("/update/new/{carId}")
    public ResponseEntity<Car> updateNewCar(@PathVariable Long carId, @RequestBody NewCarDto newCarDto) {
        return ResponseEntity.ok(carsService.updateNewCar(carId, newCarDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable("id") Long id) {
        carsService.deleteCar(id);
        return ResponseEntity.ok("CarInfo deleted successfully");
    }

    @GetMapping("/chassis/{chassisNumber}")
    public ResponseEntity<Car> getCarByChassisNumber(@PathVariable String chassisNumber) {
        return ResponseEntity.ok(carsService.getCarByChassisNumber(chassisNumber));
    }

    @GetMapping("/reg/{regNumber}")
    public ResponseEntity<Car> getCarByRegNumber(@PathVariable String regNumber) {
        return ResponseEntity.ok(carsService.getCarByRegNumber(regNumber));
    }

    @GetMapping("/customer/{customerName}")
    public ResponseEntity<List<Car>> getCarByCustomerName(@PathVariable String customerName) {
        return ResponseEntity.ok(carsService.getCarByCustomerName(customerName));
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<Car>> getCarByModel(@PathVariable String model) {
        return ResponseEntity.ok(carsService.getCarByModel(model));
    }
}
