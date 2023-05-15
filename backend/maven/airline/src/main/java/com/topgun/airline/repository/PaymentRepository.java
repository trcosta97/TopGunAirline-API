package com.topgun.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.topgun.airline.domain.payment.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
