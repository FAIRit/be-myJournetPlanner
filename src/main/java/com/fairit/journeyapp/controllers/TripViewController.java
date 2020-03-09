package com.fairit.journeyapp.controllers;

import com.fairit.journeyapp.accessdata.TripRepository;
import com.fairit.journeyapp.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TripViewController {

    @Autowired
    TripRepository tripRepository;

    @GetMapping("/trips")
    public String showAllTrips() {

        List<Trip> trips = tripRepository.findAll();

        String htmlString = "";
        for (Trip t: trips) {
            htmlString += t.getCity();
        }
        return htmlString;
    }
}