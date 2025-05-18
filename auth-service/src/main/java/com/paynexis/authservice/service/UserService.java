package com.paynexis.authservice.service;

import com.paynexis.authservice.dto.LoginCredentials;
import com.paynexis.authservice.model.User;
import com.paynexis.authservice.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User create(User user) {
        userRepository.save(user);
        return user;
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delete(String userId) {
        userRepository.deleteById(userId);
    }

    public ResponseEntity<User> login(@NotNull LoginCredentials loginCredentials) {
        if (checkLoginCredentials(loginCredentials)) {
            return new ResponseEntity<>(userRepository.findByUsername(loginCredentials.getUsername()), HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

    }
    public Boolean checkLoginCredentials(LoginCredentials loginCredentials) {
        User user = userRepository.findByUsername(loginCredentials.getUsername());
        return user != null && user.getPassword().equals(loginCredentials.getPassword());
    }
}
