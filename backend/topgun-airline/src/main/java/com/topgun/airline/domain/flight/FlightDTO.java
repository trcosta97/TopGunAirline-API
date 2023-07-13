package com.topgun.airline.domain.flight;

import com.topgun.airline.domain.Airport;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record FlightDTO(
        @NotNull
        LocalDate flightDate,
        @NotNull
        Airport origin,
        @NotNull
        Airport destination,
        @NotNull
        Integer availableSeats) {
}
