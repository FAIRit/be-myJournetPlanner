package com.fairit.journeyapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/")
    public String mainPage() {
        return "Welcome on awesome Sandra's page!";
    }

}
