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
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public void delete(long id){
        userRepository.deleteById(id);
    }

    @Override
    public User findUserById(long userId) {
        return null;
    }
}
