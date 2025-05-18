package com.paynexis.authservice.controller;

import com.paynexis.authservice.dto.LoginCredentials;
import com.paynexis.authservice.model.User;
import com.paynexis.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }
    @PutMapping(path = "/{userId}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable String userId) {
        user.setId(userId);
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<User> login(@RequestBody LoginCredentials loginCredentials) {
        return userService.login(loginCredentials);
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity delete(@PathVariable String userId) {
        userService.delete(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
