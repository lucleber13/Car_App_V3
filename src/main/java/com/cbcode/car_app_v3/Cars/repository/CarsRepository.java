package com.cbcode.car_app_v3.Cars.repository;

import com.cbcode.car_app_v3.Cars.model.Car;
import com.cbcode.car_app_v3.Cars.model.DTO.CarDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {
    Optional<Car> findCarByChassisNumber(String chassisNumber);
    Optional<Car> findCarByRegNumber(String regNumber);
    Optional<List<Car>> findCarByCustomerNameIgnoreCase(String customerName);
    Optional<List<Car>> findCarByModelIgnoreCase( String model);



}
