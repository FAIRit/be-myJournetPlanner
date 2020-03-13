package com.fairit.journeyapp.accessdata;

import com.fairit.journeyapp.model.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TripRepository extends CrudRepository<Trip, Integer> {

    Trip findTripById(int id);

    List<Trip> findAll();

    List<Trip> findByUserId(int userId);

}
