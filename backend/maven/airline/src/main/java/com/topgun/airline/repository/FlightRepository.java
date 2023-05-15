package com.topgun.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.topgun.airline.domain.flight.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
