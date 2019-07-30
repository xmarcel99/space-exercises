package com.space.exercises.controller;

import com.space.exercises.domain.Flight;
import com.space.exercises.domain.Tourist;
import com.space.exercises.dto.FlightDto;
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

    @GetMapping(value = "getAllFlights")
    public List<FlightDto> getAllFlights() {
        return flightMapper.mapToFlightDtoList(flightService.getAllFlights());
    }

    @PostMapping(value = "addFlight")
    public void addFlight(@RequestBody FlightDto flightDto) {
        flightService.addFlight(flightMapper.mapToFlight(flightDto));
    }

    @DeleteMapping(value = "deleteFlight")
    public void deleteFlight(@RequestParam long id) {
        flightService.deleteFlight(id);
    }

    @PutMapping(value = "addTouristToFlight")
    public void addTouristToFlight(@RequestParam long touristId,@RequestParam long flightId) throws CanNotFindTouristException, FlightException, NotEnoughtSeatsException {
        Tourist resultTourist = null;
        Flight resultFlight = null;
        for(Tourist tourist : touristService.getAllTourists()) {
            if(tourist.getId() == touristId) {
                resultTourist = tourist;
            } else {
                throw new CanNotFindTouristException();
            }
        }
        for(Flight flight : flightService.getAllFlights()) {
            if(flight.getId() == flightId) {
                resultFlight = flight;
            } else {
                throw new FlightException();
            }
        }
        if(resultFlight != null && resultTourist != null && resultFlight.getSeatsQuantity() > 0) {
            resultFlight.getTourists().add(resultTourist);
            resultFlight.setSeatsQuantity(resultFlight.getSeatsQuantity()-1);
            resultTourist.getFlights().add(resultFlight);
            touristService.addTourist(resultTourist);
            flightService.addFlight(resultFlight);
        } else {
            throw new NotEnoughtSeatsException();
        }
    }

    @PutMapping(value = "deleteTouristFromFlight")
    public void deleteTouristFromFlight(@RequestParam long touristId,@RequestParam long flightId) throws CanNotFindTouristException, FlightException {
        Tourist resultTourist = null;
        Flight resultFlight = null;
        for(Tourist tourist : touristService.getAllTourists()) {
            if(tourist.getId() == touristId) {
                resultTourist = tourist;
            } else {
                throw new CanNotFindTouristException();
            }
        }
        for(Flight flight : flightService.getAllFlights()) {
            if(flight.getId() == flightId) {
                resultFlight = flight;
            } else {
                throw new FlightException();
            }
        }
        if(resultFlight.getTourists().contains(resultTourist)) {
            resultFlight.getTourists().remove(resultTourist);
            resultTourist.getFlights().remove(resultFlight);
            resultFlight.setSeatsQuantity(resultFlight.getSeatsQuantity()+1);
        } else {
            throw new CanNotFindTouristException();
        }
        touristService.addTourist(resultTourist);
        flightService.addFlight(resultFlight);
    }
}
