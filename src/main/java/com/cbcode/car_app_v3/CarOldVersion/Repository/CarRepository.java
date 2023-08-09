package com.cbcode.car_app_v3.CarOldVersion.Repository;

import com.cbcode.car_app_v3.CarOldVersion.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findCarByChassisNumber(String chassisNumber);
    Optional<Car> findCarByRegNumber(String regNumber);
    Optional<Car> findCarByCustomerName(String customerName);
    Optional<Car> findCarByChassisNumberOrRegNumber(String chassisNumber, String regNumber);
    Optional<Car> findCarByBrandAndModel(String brand, String model);
    //Optional<CarOldVersion> findCarByDateArrivedOrDateRequired(Date dateArrived, Date dateRequired);
    //List<CarOldVersion> findCarsBySold(Boolean sold);


}
