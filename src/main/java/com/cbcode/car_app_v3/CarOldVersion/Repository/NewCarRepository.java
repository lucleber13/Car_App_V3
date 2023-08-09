package com.cbcode.car_app_v3.CarOldVersion.Repository;

import com.cbcode.car_app_v3.CarOldVersion.Model.NewCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewCarRepository extends JpaRepository<NewCar, Long> {
    Optional<NewCar> findNewCarByChassisNumber(String chassisNumber);
}
