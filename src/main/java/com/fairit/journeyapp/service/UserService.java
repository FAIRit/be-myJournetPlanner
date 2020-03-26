package com.fairit.journeyapp.service;

import com.fairit.journeyapp.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    void save(User user);

    List<User> getAllUsers();

    User findUserByUsername(String username);
}
