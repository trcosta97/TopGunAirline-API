package com.topgun.airline.domain.payment;


import com.topgun.airline.domain.reservation.Reservation;
import com.topgun.airline.domain.user.User;


import java.math.BigDecimal;

public record PaymentDTO(User user, BigDecimal value, Reservation reservation, TypeOfPayment typeOfPayment) {
}


