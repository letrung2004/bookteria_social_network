package com.bookteria.identity.controller;

import com.bookteria.identity.dto.request.UserCreationRequest;
import com.bookteria.identity.entity.User;
import com.bookteria.identity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestBody UserCreationRequest request) {
        return userService.createRequest(request);
    }

    @GetMapping("/users")
    public List<?> getUser() {
        return this.userService.getUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable String userId) {
        return this.userService.getUserById(userId);
    }
}
