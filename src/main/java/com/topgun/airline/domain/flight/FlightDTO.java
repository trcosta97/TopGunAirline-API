package com.topgun.airline.domain.flight;

import com.topgun.airline.domain.Airport;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;


public record FlightDTO(
        @NotNull
        LocalDateTime flightDate,
        @NotNull
        Airport origin,
        @NotNull
        Airport destination,
        @NotNull
        Integer availableSeats,
        @NotNull
        Double price){

}

