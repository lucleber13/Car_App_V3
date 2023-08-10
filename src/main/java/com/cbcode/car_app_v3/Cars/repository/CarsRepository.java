package com.cbcode.car_app_v3.Cars.repository;

import com.cbcode.car_app_v3.Cars.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {
    Optional<Cars> findCarByChassisNumber(String chassisNumber);
    Optional<Cars> findCarByRegNumber(String regNumber);
    Optional<List<Cars>> findCarByCustomerName(String customerName);
    Optional<Cars> findCarByChassisNumberOrRegNumber(String chassisNumber, String regNumber);
    Optional<Cars> findCarByChassisNumberAndRegNumber(String chassisNumber, String regNumber);
    Optional<Cars> findCarByBrandAndModel(String brand, String model);
    Optional<Cars> findCarByDateArrivedOrDateRequired(Date dateArrived, Date dateRequired);


}
