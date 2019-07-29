package com.space.exercises.controller;

import com.space.exercises.domain.Flight;
import com.space.exercises.domain.Tourist;
import com.space.exercises.dto.TouristDto;
import com.space.exercises.exceptions.CanNotFindTouristException;
import com.space.exercises.exceptions.FlightException;
import com.space.exercises.exceptions.NotEnoughtSeatsException;
import com.space.exercises.mapper.FlightMapper;
import com.space.exercises.mapper.TouristMapper;
import com.space.exercises.service.FlightService;
import com.space.exercises.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tourist/")
@RestController
public class TouristController {

    @Autowired
    FlightService flightService;

    @Autowired
    TouristService touristService;

    @Autowired
    FlightMapper flightMapper;

    @Autowired
    TouristMapper touristMapper;

    @GetMapping(value = "getAllTourists")
    public List<TouristDto> getAllTourists() {
        return touristMapper.mapToTouristDtoList(touristService.getAllTourists());
    }

    @PostMapping(value = "addTourist")
    public void addTourist(@RequestBody TouristDto touristDto) {
        touristService.addTourist(touristMapper.mapToTourist(touristDto));
    }

    @DeleteMapping(value = "deleteTourist")
    public void deleteTourist(long id) {
        touristService.deleteTourist(id);
    }

    @PostMapping(value = "addFlightToTourist")
    public void updateTouristFlights(long touristId, long flightId) throws FlightException, NotEnoughtSeatsException, CanNotFindTouristException {
        Tourist resultTourist = null;
        for (Tourist tourist : touristService.getAllTourists()) {
            if (tourist.getId() == touristId) {
                resultTourist = tourist;
            } else {
                throw new CanNotFindTouristException();
            }
        }
        Flight resultFlight = null;
        for (Flight flight : flightService.getAllFlights()) {
            if (flight.getId() == flightId) {
                resultFlight = flight;
            } else {
                throw new FlightException();
            }
        }
        if (resultFlight.getSeatsQuantity() > 0) {
            resultTourist.getFlights().add(resultFlight);
            resultFlight.setSeatsQuantity(resultFlight.getSeatsQuantity() - 1);
        } else {
            throw new NotEnoughtSeatsException();
        }
        flightService.addFlight(resultFlight);
        touristService.addTourist(resultTourist);
    }

    @PostMapping
    public void deleteFlightFromTourist(long touristId, long flightId) throws FlightException, CanNotFindTouristException {
        Tourist resultTourist = null;
        for (Tourist tourist : touristService.getAllTourists()) {
            if (tourist.getId() == touristId) {
                resultTourist = tourist;
            } else {
                throw new CanNotFindTouristException();
            }
        }
        Flight resultFlight = null;
        for (Flight flight : flightService.getAllFlights()) {
            if (flight.getId() == flightId) {
                resultFlight = flight;
            } else {
                throw new FlightException();
            }
        }
        if (resultTourist.getFlights().contains(resultFlight)) {
            resultTourist.getFlights().remove(resultFlight);
            resultFlight.setSeatsQuantity(resultFlight.getSeatsQuantity() + 1);
        } else {
            throw new FlightException();
        }
        touristService.addTourist(resultTourist);
        flightService.addFlight(resultFlight);
    }


}
