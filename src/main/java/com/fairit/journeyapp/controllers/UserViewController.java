package com.fairit.journeyapp.controllers;

import com.fairit.journeyapp.repository.UserRepository;
import com.fairit.journeyapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@Controller

public class UserViewController {

    public UserViewController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    UserRepository userRepository;

    @GetMapping("/user/users")
    public String showAllUsers(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "get_all_users";
    }

//    @GetMapping("/details/{userId}")
//    public String userDetails(@PathVariable("userId") Long userId, Model model){
//        model.addAttribute("userdata", userId);
//        return "user_page";
//    }

    @GetMapping("/user/details/{userId}")
    public String userDetails(@PathVariable("userId") Long userId,
                                Model model){
        User user = userRepository.findUserById(userId);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("originCountry", user.getOriginCountry());

        return "user_page";
    }

    @GetMapping("/user/register")
    public String register(Model model){
        model.addAttribute("user", new User());

        return "user_registration";
    }

    @PostMapping("/user/create")
    public String create(User user){
        userRepository.save(user);

        return "redirect:user/details/" + user.getId();
    }

    @GetMapping("/user/edit/{userId}")
    public String edit(@PathVariable("userId") long userId, Model model){
        User user = userRepository.findUserById(userId);
        model.addAttribute("user", user);

        return "user_update";
    }

    @PostMapping("/user/update")
    public String update(User user, Model model){
        //userRepository.u
        return  "redirect:user/details/" + user.getId();
    }

    @GetMapping("/user/delete/{username}")
    public String delete(@PathVariable("username") String username, Model model){
        userRepository.deleteByUsername(username);

        return "redirect:/user/users";
    }

}
