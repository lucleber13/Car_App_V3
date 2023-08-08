package com.cbcode.car_app_v3.User.controller;

import com.cbcode.car_app_v3.User.model.User;
import com.cbcode.car_app_v3.User.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }
}
