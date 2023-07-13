package com.topgun.airline.controller;

import com.topgun.airline.domain.flight.Flight;
import com.topgun.airline.domain.reservation.Reservation;
import com.topgun.airline.domain.reservation.ReservationDTO;
import com.topgun.airline.domain.reservation.ReservationUpdateDTO;
import com.topgun.airline.domain.user.User;
import com.topgun.airline.service.FlightService;
import com.topgun.airline.service.ReservationService;
import com.topgun.airline.service.UserService;
import com.topgun.airline.validation.ReservationValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private UserService userService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private ReservationValidation reservationValidation;
    @Transactional
    @PostMapping("/reservation")
    public ResponseEntity<Reservation> save(@RequestBody ReservationDTO data) {
        reservationValidation.reservationValidation(data);
        User user = userService.findUserById(data.userId());
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        Flight flight = flightService.findFlightById(data.flightId());
        if (flight == null) {
            throw new IllegalArgumentException("Flight not found");
        }
        Reservation reservation = new Reservation(data);
        reservation.setUser(user);
        reservation.setFlight(flight);
        reservation.getPayment().setUser(user);

        Reservation savedReservation = reservationService.saveReservation(reservation);

        return ResponseEntity.ok(savedReservation);
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> getById(@RequestParam Long id){
        return ResponseEntity.ok(reservationService.findReservationById(id));
    }

    @GetMapping("/reservation/user")
    public ResponseEntity<List<Reservation>> getAllByUser(){
        return ResponseEntity.ok(reservationService.findAllReservationByUser());
    }

    @GetMapping("/reservation/flight")
    public ResponseEntity<List<Reservation>> getAllByFlight(){
        return ResponseEntity.ok(reservationService.findAllReservationByFlight());
    }



    @Transactional
    @PutMapping("/reservation/{id}")
    public ResponseEntity<Reservation> update(@RequestBody ReservationUpdateDTO data, @RequestParam Long id){
        var newReservation = new Reservation(data);
        return ResponseEntity.ok(reservationService.updateReservation(id, newReservation));
    }

    @Transactional
    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<Reservation> delete(@RequestParam Long id){
        return ResponseEntity.ok(reservationService.deleteReservation(id));
    }

}
