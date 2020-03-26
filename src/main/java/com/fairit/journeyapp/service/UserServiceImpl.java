package com.fairit.journeyapp.service;

import com.fairit.journeyapp.model.User;
import com.fairit.journeyapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public void save(User user) {
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
