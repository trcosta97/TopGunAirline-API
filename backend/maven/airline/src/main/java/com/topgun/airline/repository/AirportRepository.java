package com.topgun.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.topgun.airline.domain.airport.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}
