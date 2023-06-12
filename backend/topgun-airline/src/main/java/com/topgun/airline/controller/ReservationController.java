package com.topgun.airline.controller;

import com.topgun.airline.domain.reservation.Reservation;
import com.topgun.airline.domain.reservation.ReservationDTO;
import com.topgun.airline.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reservation")
    public ResponseEntity<Reservation> save(@RequestBody ReservationDTO data){
        var reservation = new Reservation(data);
        return ResponseEntity.ok(reservationService.saveReservation(reservation));
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> getById(@RequestParam Long id){
        return ResponseEntity.ok(reservationService.findReservationById(id));
    }

    @GetMapping("/reservation")
    public ResponseEntity<List<Reservation>> getAll(){
        return ResponseEntity.ok(reservationService.findAllReservation());
    }

    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<Reservation> delete(@RequestParam Long id){
        return ResponseEntity.ok(reservationService.deleteReservation(id));
    }

}
