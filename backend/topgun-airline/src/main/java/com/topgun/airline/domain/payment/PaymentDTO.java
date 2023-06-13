package com.topgun.airline.domain.payment;


import com.topgun.airline.domain.reservation.Reservation;
import com.topgun.airline.domain.user.User;


import java.math.BigDecimal;

public record PaymentDTO(Long userId, BigDecimal value, TypeOfPayment typeOfPayment) {
}


