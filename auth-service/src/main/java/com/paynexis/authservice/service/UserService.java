package com.paynexis.authservice.service;

import com.paynexis.authservice.model.User;
import com.paynexis.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User create(User user) {
        userRepository.save(user);
        return user;
    }
}
