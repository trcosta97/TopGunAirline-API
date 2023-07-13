package com.topgun.airline.domain.reservation;


import com.topgun.airline.domain.payment.PaymentDTO;
import jakarta.validation.constraints.NotNull;


public record ReservationDTO(
        @NotNull
        Long flightId,
        @NotNull
        Long userId,
        @NotNull
        Integer numberOfSeats,
        @NotNull
        PaymentDTO payment) {
}
