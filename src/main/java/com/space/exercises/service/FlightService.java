package com.space.exercises.service;

import com.space.exercises.dao.FlightDao;
import com.space.exercises.dao.TouristDao;
import com.space.exercises.domain.Flight;
import com.space.exercises.domain.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightService {

    @Autowired
    FlightDao flightDao;

    @Autowired
    TouristDao touristDao;

    public List<Flight> getAllFlights() {
        return (List<Flight>) flightDao.findAll();
    }

    public void addFlight(Flight flight) {
        flightDao.save(flight);
    }

    public void deleteFlight(long id) {
        flightDao.deleteById(id);
    }

    public void addTouristToFlight(long flightId, long touristId) {
        Flight flight = flightDao.findById(flightId);
        if(flight.getSeatsQuantity() > 0) {
            Tourist tourist = touristDao.findById(touristId);
            flight.getTourists().add(tourist);
            flight.setSeatsQuantity(flight.getSeatsQuantity()-1);
            Flight resultFlight = new Flight(flight.getId(),flight.getDepartues(),flight.getArrival(),flight.getSeatsQuantity(),flight.getPriceOfTicket());
            resultFlight.getTourists().addAll(flight.getTourists());
            flightDao.save(resultFlight);
        }
    }

    public void deleteTouristFromFlight(long flightId, long touristId) {
        Flight flight = flightDao.findById(flightId);
        Tourist tourist = touristDao.findById(touristId);

        if(flight.getTourists().contains(tourist)) {
            flight.getTourists().remove(tourist);
            flight.setSeatsQuantity(flight.getSeatsQuantity()+1);
            Flight resultFlight = new Flight(flight.getId(),flight.getDepartues(),flight.getArrival(),flight.getSeatsQuantity(),flight.getPriceOfTicket());
            resultFlight.getTourists().addAll(flight.getTourists());
            flightDao.save(resultFlight);
        }
    }
}
