package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.entity.Users;
import com.example.user.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService userService;

    @PostMapping("/create")
    public ResponseEntity<Users> create(@RequestBody Users users) {
        Users savedUser = userService.save(users);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable String userId) {
        Users user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

}
