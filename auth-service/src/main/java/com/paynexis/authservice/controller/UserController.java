package com.paynexis.authservice.controller;

import com.paynexis.authservice.model.User;
import com.paynexis.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }
    @PutMapping(path = "/{RequestParameter}")
    public User update(@RequestBody User user, @PathVariable String RequestParameter) {
        user.setId(RequestParameter);
        return userService.update(user);
    }

    @DeleteMapping(path = "/{RequestParameter}")
    public void delete(@PathVariable String RequestParameter) {
        userService.delete(userService.getUserById(RequestParameter));
    }
}
