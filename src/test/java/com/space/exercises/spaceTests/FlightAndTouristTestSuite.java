package com.space.exercises.spaceTests;

import com.space.exercises.dao.FlightDao;
import com.space.exercises.dao.TouristDao;
import com.space.exercises.domain.Flight;
import com.space.exercises.domain.Tourist;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlightAndTouristTestSuite {

    @Autowired
    FlightDao flightDao;

    @Autowired
    TouristDao touristDao;

    @Test
    public void shouldAddToDataBase() {
        //Given
        Tourist tourist = new Tourist("Marcel","Sztur",'M',"Poland",new ArrayList<>(), LocalDate.now(),new ArrayList<>());
        Flight flight = new Flight(LocalDateTime.now(),LocalDateTime.now(),100,new ArrayList<>(),new BigDecimal(100));
        flight.getTourists().add(tourist);
        tourist.getFlights().add(flight);
        //When
        flightDao.save(flight);
        //Then
        Assert.assertTrue(flight.getTourists().size() == 1);
    }
}
