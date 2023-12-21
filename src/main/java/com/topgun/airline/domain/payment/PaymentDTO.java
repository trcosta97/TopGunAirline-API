package com.topgun.airline.domain.payment;


import com.topgun.airline.domain.reservation.Reservation;
import com.topgun.airline.domain.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;

public record PaymentDTO(
        @NotNull
        Long userId,
        @NotNull
        BigDecimal value,
        @NotNull
        TypeOfPayment typeOfPayment) {
}


