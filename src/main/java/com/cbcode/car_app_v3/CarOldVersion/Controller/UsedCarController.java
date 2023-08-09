package com.cbcode.car_app_v3.CarOldVersion.Controller;

import com.cbcode.car_app_v3.CarOldVersion.Model.UsedCar;
import com.cbcode.car_app_v3.CarOldVersion.service.UsedCarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/usedcars")
public class UsedCarController {

    private final UsedCarService usedCarService;

    public UsedCarController(UsedCarService usedCarService) {
        this.usedCarService = usedCarService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addUsedCar(@RequestBody UsedCar usedCar) {
        usedCarService.addUsedCar(usedCar);
        return ResponseEntity.ok("Used car added successfully");
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<UsedCar>> getAllUsedCars() {
        return ResponseEntity.ok(usedCarService.getAllUsedCars());
    }

    @PatchMapping(path = "/update/{id}")
    public ResponseEntity<String> updateUsedCar(@PathVariable("id") long id, @RequestBody UsedCar usedCar) {
        usedCarService.updateUsedCar(usedCar);
        return ResponseEntity.ok("Used car updated successfully");
    }

    @GetMapping(path = "/{id}")
    public UsedCar getUsedCarById(@PathVariable("id") long id) {
        return usedCarService.getUsedCarById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUsedCarById(@PathVariable("id") long id) {
        usedCarService.deleteUsedCarById(id);
        return ResponseEntity.ok("Used car deleted successfully");
    }
}
