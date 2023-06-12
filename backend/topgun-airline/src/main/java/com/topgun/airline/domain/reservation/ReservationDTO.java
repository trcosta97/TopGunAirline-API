package com.topgun.airline.domain.reservation;

import com.topgun.airline.domain.flight.Flight;
import com.topgun.airline.domain.payment.Payment;
import com.topgun.airline.domain.user.User;

public record ReservationDTO(Flight flight, User user, Integer numberOfSeats, Payment payment) {
}
