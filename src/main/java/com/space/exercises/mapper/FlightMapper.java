package com.space.exercises.mapper;

import com.space.exercises.domain.Flight;
import com.space.exercises.dto.FlightDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightMapper {

    public Flight mapToFlight(FlightDto flightDto) {
        return new Flight(flightDto.getId(),
                flightDto.getDepartues(),
                flightDto.getArrival(),flightDto.getSeatsQuantity(),
                flightDto.getPriceOfTicket());
    }

    public List<Flight> mapToFlightList(List<FlightDto> flightDtos) {
        return flightDtos.stream()
                .map(flightDto -> new Flight(flightDto.getId(),
                        flightDto.getDepartues(),flightDto.getArrival(),
                        flightDto.getSeatsQuantity(),
                        flightDto.getPriceOfTicket()))
                .collect(Collectors.toList());
    }

    public FlightDto mapToFlightDto(Flight flight) {
        return  new FlightDto(flight.getId(),
                flight.getDepartues(),
                flight.getArrival(),
                flight.getSeatsQuantity(),
                flight.getPriceOfTicket());
    }

    public List<FlightDto> mapToFlightDtoList(List<Flight> flights) {
        return flights.stream()
                .map(flight -> new FlightDto(flight.getId(),
                        flight.getDepartues(),
                        flight.getArrival(),
                        flight.getSeatsQuantity(),
                        flight.getPriceOfTicket()))
                .collect(Collectors.toList());
    }
}
