package com.topgun.airline.domain.payment;


import com.topgun.airline.domain.Reservation;
import com.topgun.airline.domain.TypeOfPayment;
import com.topgun.airline.domain.user.User;


import java.math.BigDecimal;
import java.util.Date;

public record PaymentDTO(User user, BigDecimal value, Reservation reservation, TypeOfPayment typeOfPayment) {
}


