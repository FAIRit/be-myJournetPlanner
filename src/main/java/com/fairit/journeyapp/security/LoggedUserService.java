//package com.fairit.journeyapp.security;
//
//import com.fairit.journeyapp.model.User;
//import com.fairit.journeyapp.repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.security.Principal;
//
//@Service
//public class LoggedUserService {
//
//    private final UserRepository userRepository;
//
//    public LoggedUserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public User getUser(Principal principal){
//        String username = principal.getName();
//        return  userRepository.findUserByUsername(username);
//    }
//
//}
