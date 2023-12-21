package com.topgun.airline.validation;

import com.topgun.airline.domain.flight.FlightDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Service
public class FlightValidation {

    public void flightValidation(FlightDTO data){
        if(data.flightDate().isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("Flight date has passed.");
        }
        if(data.origin() == data.destination()){
            throw new IllegalArgumentException("Flight origin can't be the same as destination");
        }
    }
}
