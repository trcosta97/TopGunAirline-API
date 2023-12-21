package com.topgun.airline.repository;

import com.topgun.airline.domain.Airport;
import com.topgun.airline.domain.flight.Flight;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByActiveTrue(Sort sort);

}