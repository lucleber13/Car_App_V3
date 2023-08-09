package com.cbcode.car_app_v3.CarOldVersion.Controller;

import com.cbcode.car_app_v3.CarOldVersion.Model.NewCar;
import com.cbcode.car_app_v3.CarOldVersion.service.NewCarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/newcars")
public class NewCarController {

    private final NewCarService newCarService;

    public NewCarController(NewCarService newCarService) {
        this.newCarService = newCarService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addNewCar(@RequestBody NewCar newCar) {
        newCarService.addNewCar(newCar);
        return ResponseEntity.ok("New car added successfully");
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<NewCar>> getAllNewCars() {
        return ResponseEntity.ok(newCarService.getAllNewCars());
    }

    @PatchMapping(path = "/update/{id}")
    public ResponseEntity<String> updateNewCar(@PathVariable("id") long id, @RequestBody NewCar newCar) {
        newCarService.updateNewCar(newCar);
        return ResponseEntity.ok("New car updated successfully");
    }

    @GetMapping(path = "/{id}")
    public NewCar getNewCarById(@PathVariable("id") long id) {
        return newCarService.getNewCarById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteNewCarById(@PathVariable("id") long id) {
        newCarService.deleteNewCarById(id);
        return ResponseEntity.ok("New car deleted successfully");
    }
}
