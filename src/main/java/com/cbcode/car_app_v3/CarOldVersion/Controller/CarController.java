package com.cbcode.car_app_v3.CarOldVersion.Controller;

import com.cbcode.car_app_v3.CarOldVersion.Model.Car;
import com.cbcode.car_app_v3.CarOldVersion.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/new/add")
    public ResponseEntity<Car> addNewCar(@RequestBody Car car) {
        return ResponseEntity.ok(carService.createCar(car));
    }
}

