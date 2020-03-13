package com.fairit.journeyapp.controllers;

import com.fairit.journeyapp.accessdata.UserRepository;
import com.fairit.journeyapp.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserViewController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public String showAllUsers(Model model){
        List<AppUser> users = userRepository.findAll();
        model.addAttribute("users", users);

        return "get_all_users";
    }
}
