package com.cbcode.car_app_v3.Car.Repository;

import com.cbcode.car_app_v3.Car.Model.UsedCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsedCarRepository extends JpaRepository<UsedCar, Long> {
    Optional<UsedCar> findUsedCarByChassisNumber(String chassisNumber);

    Optional<UsedCar> findUsedCarByRegNumber(String regNumber);
}
