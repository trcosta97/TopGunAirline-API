package com.topgun.airline.validation;

import com.topgun.airline.domain.flight.Flight;
import com.topgun.airline.domain.reservation.ReservationDTO;
import com.topgun.airline.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationValidation {
    @Autowired
    FlightService flightService;

    public void reservationValidation(ReservationDTO data){
        Flight flight = flightService.findFlightById(data.flightId());

        if(data.numberOfSeats() > flight.getAvailableSeats()){
            throw new IllegalArgumentException("There's not enough seats for this reservation");
        }
    }



}
