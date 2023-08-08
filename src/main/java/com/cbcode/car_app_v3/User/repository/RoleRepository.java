package com.cbcode.car_app_v3.User.repository;

import com.cbcode.car_app_v3.User.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name); // This is a custom method that will be used to find a role by its name
}
