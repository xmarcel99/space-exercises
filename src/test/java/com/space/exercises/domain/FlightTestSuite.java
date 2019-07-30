package com.space.exercises.domain;

import com.space.exercises.dao.FlightDao;
import com.space.exercises.dao.TouristDao;
import com.space.exercises.mapper.FlightMapper;
import com.space.exercises.mapper.TouristMapper;
import com.space.exercises.service.FlightService;
import com.space.exercises.service.TouristService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlightTestSuite {

    @Autowired
    FlightService flightService;

    @Autowired
    TouristService touristService;

    @Autowired
    FlightMapper flightMapper;

    @Autowired
    TouristMapper touristMapper;

    @Autowired
    FlightDao flightDao;

    @Autowired
    TouristDao touristDao;

    public Flight createContent() {
        return new Flight(LocalDateTime.now(),LocalDateTime.now(),100,new BigDecimal(1000));
    }

    Logger LOGGER = LoggerFactory.getLogger(FlightTestSuite.class);

    @Test
    public void shouldAddToDB() {
        //Given
        Flight flight = createContent();
        flightService.addFlight(flight);
        //Then
        long recordsCount = flightDao.count();
        //Then
        assertEquals(1,recordsCount);
        //Clean up
        flightDao.deleteById(flight.getId());
    }

    @Test
    public void shouldDeleteFromDB() {
        //Given
        Flight flight = createContent();
        //When
        flightService.addFlight(flight);
        LOGGER.info("Records count : " + flightDao.count());
        long sizeAfterAdd = flightDao.count();
        flightService.deleteFlight(flight.getId());
        LOGGER.info("Records count : " + flightDao.count());
        long sizeAfterRemove = flightDao.count();
        //Then
        assertTrue(sizeAfterAdd - sizeAfterRemove == 1);
    }

    @Test
    public void shouldUpdateFlight() {
        //Given
        Flight flight = createContent();
        //When
        flightService.addFlight(flight);
        Flight resultFlight = flightDao.findById(flight.getId());
        resultFlight.setSeatsQuantity(50);
        flightService.addFlight(resultFlight);
        //Then
        assertTrue(flightDao.findById(flight.getId()).getSeatsQuantity() == 50);
        //CleanUp
        flightService.deleteFlight(flight.getId());
    }


}