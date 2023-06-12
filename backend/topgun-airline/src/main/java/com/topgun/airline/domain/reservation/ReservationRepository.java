package com.topgun.airline.domain.reservation;

import com.topgun.airline.domain.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByActiveTrue();
}
