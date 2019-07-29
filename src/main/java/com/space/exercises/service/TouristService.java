package com.space.exercises.service;

import com.space.exercises.dao.FlightDao;
import com.space.exercises.dao.TouristDao;
import com.space.exercises.domain.Flight;
import com.space.exercises.domain.Tourist;
import com.space.exercises.exceptions.FlightException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TouristService {

    @Autowired
    TouristDao touristDao;

    @Autowired
    FlightDao flightDao;

    public List<Tourist> getAllTourists() {
        return (List<Tourist>) touristDao.findAll();
    }

    public void addTourist(Tourist tourist) {
        touristDao.save(tourist);
    }

    public void deleteTourist(long id) {
        touristDao.deleteById(id);
    }

    public void addFlightToTourist(long flighId, long touristId) throws FlightException{
        List<Flight> flights = flightDao.findFlightWithFreeSeats();
        Flight foundFlight = null;
        for(Flight flight : flights) {
            if(flight.getId() == flighId) {
                foundFlight = flight;
            } else {
                throw new FlightException();
            }
        }
        Tourist tourist = touristDao.findById(touristId);
        foundFlight.setSeatsQuantity(foundFlight.getSeatsQuantity()-1);
        tourist.getFlights().add(foundFlight);
        Tourist resultTourist = new Tourist(tourist.getId(),tourist.getFirstname(),
                tourist.getLastname(),
                tourist.getMale(),
                tourist.getCountry(),
                tourist.getBirthDate());
        resultTourist.getFlights().addAll(tourist.getFlights());
        resultTourist.getNotes().addAll(tourist.getNotes());
        touristDao.save(resultTourist);
    }

    public void deleteFlightFromTourist(long flightId, long touristId) {
        Tourist tourist = touristDao.findById(touristId);
        Flight flight = flightDao.findById(flightId);

        for(Flight f: tourist.getFlights()) {
            if(f.equals(flight)) {
                tourist.getFlights().remove(f);
                Tourist resultTourist = new Tourist(tourist.getId(),tourist.getFirstname(),
                        tourist.getLastname(),
                        tourist.getMale(),
                        tourist.getCountry(),
                        tourist.getBirthDate());
                resultTourist.getFlights().addAll(tourist.getFlights());
                resultTourist.getNotes().addAll(tourist.getNotes());
                touristDao.save(resultTourist);
            }
        }
    }
}
