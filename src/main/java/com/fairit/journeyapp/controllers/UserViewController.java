package com.fairit.journeyapp.controllers;

import com.fairit.journeyapp.repository.UserRepository;
import com.fairit.journeyapp.model.User;
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
    public String create(User user){
        userRepository.save(user);

        return "redirect:user/details/" + user.getId();
    }

    @GetMapping("/user/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login_page";
    }

    @PostMapping("/user/login")
    public String loginHandler(@ModelAttribute User user) {
        User userFromDB = userRepository.findUserByUsername(user.getUsername());
        if(userFromDB != null) {
            if(userFromDB.getUsername().equals(user.getUsername()) &&
            userFromDB.getPassword().equals(user.getPassword())) {
                return "redirect:/";
            }
        }

        return "login_page";
    }

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
