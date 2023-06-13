package com.topgun.airline.domain.reservation;


import com.topgun.airline.domain.payment.PaymentDTO;



public record ReservationDTO(Long flightId, Long userId, Integer numberOfSeats, PaymentDTO payment) {
}
