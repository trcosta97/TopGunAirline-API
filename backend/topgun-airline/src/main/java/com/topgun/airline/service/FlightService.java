package com.topgun.airline.service;


import com.topgun.airline.domain.flight.Flight;
import com.topgun.airline.domain.flight.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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


    public List<Flight> findAllFlights(){
        Sort sort = Sort.by("flightDate").descending();
        return flightRepository.findAllByActiveTrue(sort);
    }

    public List<Flight> findAllFlightsByDestination(){
        Sort sort = Sort.by("destination").descending();
        return flightRepository.findAllByActiveTrue(sort);
    }

    public List<Flight> findAllFlightsByOrigin(){
        Sort sort = Sort.by("origin").descending();
        return flightRepository.findAllByActiveTrue(sort);
    }


    public Flight updateFlight(Long id, Flight inputFlight){
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if(optionalFlight.isPresent()){
            Flight updatedFlight = optionalFlight.get();

            if(inputFlight.getFlightDate() != null){
                updatedFlight.setFlightDate(inputFlight.getFlightDate());
            }
            if(inputFlight.getOrigin() !=null){
                updatedFlight.setOrigin(inputFlight.getOrigin());
            }
            if(inputFlight.getDestination() != null){
                updatedFlight.setDestination(inputFlight.getDestination());
            }
            if(inputFlight.getAvailableSeats() != null){
                updatedFlight.setAvailableSeats(inputFlight.getAvailableSeats());
            }

            flightRepository.save(updatedFlight);
            return updatedFlight;
        }
        return null;
    }

    public Flight deleteFlight(Long id){
        Optional<Flight> optionalFlight = flightRepository.findById(id);
        if(optionalFlight.isPresent()){
            Flight flight = optionalFlight.get();
            flight.setActive(false);
            return flightRepository.save(flight);
        }
        return null;
    }
}
