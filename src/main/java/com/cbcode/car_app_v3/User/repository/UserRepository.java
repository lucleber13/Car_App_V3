package com.cbcode.car_app_v3.User.repository;

import com.cbcode.car_app_v3.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email); // This is a custom method that will be used to find a user by their email
    Optional<User> findByFirstName(String firstName); // This is a custom method that will be used to find a user by their first name
}
