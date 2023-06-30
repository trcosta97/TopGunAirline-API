package com.topgun.airline.domain.flight;

import com.topgun.airline.domain.Airport;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findAllByActiveTrue(Sort sort);

}