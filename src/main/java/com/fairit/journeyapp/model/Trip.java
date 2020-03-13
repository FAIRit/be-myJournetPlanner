package com.fairit.journeyapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name="trip")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id", updatable = false, nullable = false)
    private int id;
    @Column(name = "trip_country")
    private String country;
    @Column(name = "trip_city")
    private String city;
    @Column(name = "trip_first_day")
    private Date firstDay;
    @Column(name = "trip_last_day")
    private Date lastDay;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private AppUser user;



}
