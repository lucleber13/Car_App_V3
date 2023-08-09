package com.cbcode.car_app_v3.CarOldVersion.Repository;

import com.cbcode.car_app_v3.CarOldVersion.Model.UsedCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsedCarRepository extends JpaRepository<UsedCar, Long> {
    Optional<UsedCar> findUsedCarByChassisNumberOrRegNumber(String chassisNumber, String regNumber);
}
