package com.topgun.airline.service;

import com.topgun.airline.domain.Flight;
import com.topgun.airline.domain.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight saveFlight(Flight newFlight){
        return flightRepository.save(newFlight);
    }

    public Flight findFlightById(Long id){
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        return optionalFlight.orElse(null);
    }

    public List<Flight> AllFlights(){
        return flightRepository.findAllByActiveTrue();
    }

    public Flight updateFlight(Long id, Flight inputFlight){
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if(optionalFlight.isPresent()){
            Flight updatedFlight = optionalFlight.get();
            updatedFlight.setFlightDate(inputFlight.getFlightDate());
            updatedFlight.setOrigin(inputFlight.getOrigin());
            updatedFlight.setDestination(inputFlight.getDestination());
            updatedFlight.setAvailableSeats(inputFlight.getAvailableSeats());
            flightRepository.save(inputFlight);
            return updatedFlight;
        }
        return null;
    }

    public Flight deleteFlight(Long id){
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if(optionalFlight.isPresent()){
            Flight flight = optionalFlight.get();
            flight.deactivateFlight();
            return flightRepository.save(flight);
        }
        return null;
    }
}
