package com.topgun.airline.domain.flight;

import com.topgun.airline.domain.Airport;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record FlightDTO(LocalDate flightDate, Airport origin, Airport destination, Integer availableSeats) {
}
