package com.cbcode.car_app_v3.User.services.impl;

import com.cbcode.car_app_v3.User.model.Role;
import com.cbcode.car_app_v3.User.model.User;
import com.cbcode.car_app_v3.User.repository.RoleRepository;
import com.cbcode.car_app_v3.User.repository.UserRepository;
import com.cbcode.car_app_v3.User.services.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public User create(User createUser) {
        Optional<User> existingUser = userRepository.findByEmail(createUser.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("User with email " + createUser.getEmail() + " already exists");
        }
        Role role = createUser.getRole();
        User user = new User();
        user.setFirstName(createUser.getFirstName());
        user.setLastName(createUser.getLastName());
        user.setEmail(createUser.getEmail());
        user.setPassword(createUser.getPassword());
        user.setRole(role);
        return userRepository.save(user);
    }
}
