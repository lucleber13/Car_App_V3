package com.cbcode.car_app_v3.Cars.controller;

import com.cbcode.car_app_v3.Cars.model.Cars;
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
    public ResponseEntity<Cars> createNewCar(@RequestBody NewCarDto newCarDto) {
        Cars newCar = modelMapper.map(newCarDto, Cars.class);
        return ResponseEntity.ok(carsService.createCar(newCar));
    }

    @PostMapping("/used")
    public ResponseEntity<Cars> createUsedCar(@RequestBody UsedCarDto usedCarDto) {
        Cars newCar = modelMapper.map(usedCarDto, Cars.class);
        return ResponseEntity.ok(carsService.createCar(newCar));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cars> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carsService.getCarById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cars>> getAllCars() {
        return ResponseEntity.ok(carsService.getAllCars());
    }

    @PutMapping("/update/used")
    public ResponseEntity<Cars> updateUsedCar(@RequestBody UsedCarDto usedCarDto) {
        return ResponseEntity.ok(carsService.updateUsedCar( usedCarDto));
    }

    @PutMapping("/update/new/{carId}")
    public ResponseEntity<Cars> updateNewCar(@PathVariable Long carId, @RequestBody NewCarDto newCarDto) {
        return ResponseEntity.ok(carsService.updateNewCar(carId, newCarDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable("id") Long id) {
        carsService.deleteCar(id);
        return ResponseEntity.ok("Car deleted successfully");
    }

    @GetMapping("/chassis/{chassisNumber}")
    public ResponseEntity<Cars> getCarByChassisNumber(@PathVariable String chassisNumber) {
        return ResponseEntity.ok(carsService.getCarByChassisNumber(chassisNumber));
    }

    @GetMapping("/reg/{regNumber}")
    public ResponseEntity<Cars> getCarByRegNumber(@PathVariable String regNumber) {
        return ResponseEntity.ok(carsService.getCarByRegNumber(regNumber));
    }

    @GetMapping("/customer/{customerName}")
    public ResponseEntity<List<Cars>> getCarByCustomerName(@PathVariable String customerName) {
        return ResponseEntity.ok(carsService.getCarByCustomerName(customerName));
    }
}
