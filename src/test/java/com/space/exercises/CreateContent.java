package com.space.exercises;


import com.space.exercises.domain.Flight;
import com.space.exercises.domain.Tourist;
import com.space.exercises.service.FlightService;
import com.space.exercises.service.TouristService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CreateContent {

    @Autowired
    FlightService flightService;

    @Autowired
    TouristService touristService;

    @Test
    public void createContent() {
        Flight flight = new Flight(LocalDateTime.now(),LocalDateTime.now(),100,new BigDecimal(1000));
        Tourist tourist = new Tourist("Jessi","Pinkman",'M',"USA", LocalDate.now());
        flightService.addFlight(flight);
        touristService.addTourist(tourist);
    }
}
