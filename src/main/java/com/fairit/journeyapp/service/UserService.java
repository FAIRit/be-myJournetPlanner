package com.fairit.journeyapp.service;

import com.fairit.journeyapp.model.User;
import com.fairit.journeyapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    void save(User user);

    User findByUsername(String username);

    User findById(Long userId);
}
