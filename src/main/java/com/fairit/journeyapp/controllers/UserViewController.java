package com.fairit.journeyapp.controllers;

import com.fairit.journeyapp.repository.UserRepository;
import com.fairit.journeyapp.model.User;
import com.fairit.journeyapp.service.SecurityService;
import com.fairit.journeyapp.service.UserService;
import com.fairit.journeyapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@Controller
public class UserViewController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @GetMapping("/user/users")
    public String showAllUsers(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "get_all_users";
    }


    @GetMapping("user/details/{userId}")
    public String userDetails(@PathVariable("userId") Long userId,
                                Model model){
        User user = userRepository.findUserById(userId);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("originCountry", user.getOriginCountry());
        model.addAttribute("trips", user.getTripsList());

        return "user_page";
    }

    @GetMapping("/user/register")
    public String register(Model model){
        model.addAttribute("user", new User());

        return "user_registration";
    }

    @PostMapping("/user/create")
    public String create(@ModelAttribute("user") User user, BindingResult bindingResult){
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()){
            return "user_registration";
        }

        userService.save(user);

        securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());

        return "redirect:user/details/" + user.getId();
    }

    @GetMapping("/user/login")
    public String login(Model model, String error, String logout){
        if (error != null)
            model.addAttribute("error",  "Your username or password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "user_login";

    }

//    @GetMapping("/user/edit/{userId}")
//    public String edit(@PathVariable("userId") long userId, Model model){
//        User user = userRepository.findUserById(userId);
//        model.addAttribute("user", user);
//
//        return "user_update";
//    }
//
//    @PostMapping("/user/update")
//    public String update(User user, Model model){
//        //userRepository.u
//        return  "redirect:user/details/" + user.getId();
//    }

    @GetMapping("/edit/{userId}")
    public String showUpdateForm(@PathVariable("userId") long userId, Model model){
        User user = userRepository.findUserById(userId);
        model.addAttribute("user", user);
        return "user_update";
    }

    @PostMapping("/update/{userId}")
    public String updateUser(@PathVariable("userId") long userId, @Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            user.setId(userId);
            return "user_update";
        }
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }

    @GetMapping("/user/delete/{userId}")
    public String deleteUser(@PathVariable("userId") long userId, Model model){
        User user = userRepository.findUserById(userId);
        userRepository.delete(user);
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }


}
