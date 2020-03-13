package com.fairit.journeyapp.controllers;

import com.fairit.journeyapp.accessdata.TripRepository;
import com.fairit.journeyapp.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class TripViewController {

    @Autowired
    TripRepository tripRepository;

    @GetMapping("/trips")
    public String showAllTrips(Model model) {
        List<Trip> trips = tripRepository.findAll();
        model.addAttribute("trips", trips);

        return "get_all_trips";
    }

    @GetMapping("/get_by_user_id/{id}")
    public String getByUserId(@PathVariable(value = "id") int userId, Model model){
        List<Trip> trips = tripRepository.findByUserId(userId);
        model.addAttribute("trips", trips);

        return "get_by_user_id";
    }
}