package com.topgun.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.topgun.airline.domain.reservation.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
