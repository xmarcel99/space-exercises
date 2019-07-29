package com.space.exercises.controller;

import com.space.exercises.mapper.FlightMapper;
import com.space.exercises.mapper.TouristMapper;
import com.space.exercises.service.FlightService;
import com.space.exercises.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight/")
public class FlightController {

    @Autowired
    FlightService flightService;

    @Autowired
    TouristService touristService;

    @Autowired
    FlightMapper flightMapper;

    @Autowired
    TouristMapper touristMapper;


}
