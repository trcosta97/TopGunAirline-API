package com.topgun.airline.controller;


import com.topgun.airline.domain.flight.Flight;
import com.topgun.airline.domain.flight.FlightDTO;
import com.topgun.airline.service.FlightService;
import com.topgun.airline.validation.FlightValidation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@SecurityRequirement(name = "bearer-key")
public class FlightController {

    @Autowired
    private FlightService flightService;
    @Autowired
    private FlightValidation validation;
    @Transactional
    @PostMapping("/flight")
    public ResponseEntity<Flight> save(@RequestBody @Valid FlightDTO data, UriComponentsBuilder uriBuilder){
        validation.flightValidation(data);
        var flight = new Flight(data);
        Flight savedFlight = flightService.saveFlight(flight);

        var uri = uriBuilder.path("/flight/{id}").buildAndExpand(savedFlight.getId()).toUri();
        return ResponseEntity.created(uri).body(savedFlight);
    }

    @GetMapping("/flight/all")
    public ResponseEntity<List<Flight>> getAll(){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Ordered by: ", "Flight date");
        return new ResponseEntity<>(flightService.findAllFlights(),responseHeaders, 200);
    }

    @GetMapping("/flight/destination")
    public ResponseEntity<List<Flight>> getAllByDestination(){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Ordered by: ", "Flight destination");
        return new ResponseEntity<>(flightService.findAllFlightsByDestination(), responseHeaders, 200);
    }

    @GetMapping("/flight/origin")
    public ResponseEntity<List<Flight>> getAllByOrigin(){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Ordered by: ", "Flight origin");
        return new ResponseEntity<>(flightService.findAllFlightsByOrigin(), responseHeaders, 200);
    }

    @GetMapping("flight/{id}")
    public ResponseEntity<Flight> getById(@PathVariable Long id){
        return ResponseEntity.ok(flightService.findFlightById(id));
    }


    @Transactional
    @PutMapping("flight/{id}")
    public ResponseEntity<Flight> update(@RequestBody FlightDTO data, @RequestParam Long id){
        validation.flightValidation(data);
        var flight = new Flight(data);
        Flight updatedFlight = flightService.updateFlight(id,flight);
        return ResponseEntity.ok(updatedFlight);

    }
    @Transactional
    @DeleteMapping("flight/{id}")
    public ResponseEntity<Flight> delete(@RequestParam Long id){
        return ResponseEntity.ok(flightService.deleteFlight(id));
    }

}
