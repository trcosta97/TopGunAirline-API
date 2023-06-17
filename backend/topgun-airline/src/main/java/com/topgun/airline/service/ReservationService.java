package com.topgun.airline.service;

import com.topgun.airline.domain.reservation.Reservation;
import com.topgun.airline.domain.reservation.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public Reservation saveReservation(Reservation newReservation){
        return reservationRepository.save(newReservation);
    }

    public Reservation findReservationById(Long id){
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        return optionalReservation.orElse(null);
    }

    public List<Reservation> findAllReservation(){
        return reservationRepository.findAllByActiveTrue();
    }

    public Reservation updateReservation(Long id, Reservation inputReservation){
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if(optionalReservation.isPresent()){
            Reservation updatedReservation = optionalReservation.get();

            if(inputReservation.getReservationDate() != null){
                updatedReservation.setReservationDate(inputReservation.getReservationDate());
            }
            if(inputReservation.getPayment() != null){
                updatedReservation.setPayment(inputReservation.getPayment());
            }
            if(inputReservation.getUser() != null){
                updatedReservation.setUser(inputReservation.getUser());
            }
            if(inputReservation.getFlight() != null){
                updatedReservation.setFlight(inputReservation.getFlight());
            }
            if(inputReservation.getNumberOfSeats() != null) {
                updatedReservation.setNumberOfSeats(inputReservation.getNumberOfSeats());
            }
            reservationRepository.save(inputReservation);
            return updatedReservation;
        }
        return null;
    }

    public Reservation deleteReservation(Long id){
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        if(optionalReservation.isPresent()){
            Reservation reservation = optionalReservation.get();
            reservation.setActive(false);
            reservationRepository.save(reservation);
        }
        return null;
    }

}
