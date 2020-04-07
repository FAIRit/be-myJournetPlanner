package com.fairit.journeyapp.repository;

import com.fairit.journeyapp.model.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TripRepository extends CrudRepository<Trip, Long> {

    Trip findTripById(Long id);
    List<Trip> findAll();

    List<Trip> findByUserId(Long userId);

    Trip save(Trip trip);

}
