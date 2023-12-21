package com.topgun.airline.repository;

import com.topgun.airline.domain.reservation.Reservation;
import com.topgun.airline.domain.user.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByActiveTrue(Sort sort);

    Reservation findByUser(User user);
}
