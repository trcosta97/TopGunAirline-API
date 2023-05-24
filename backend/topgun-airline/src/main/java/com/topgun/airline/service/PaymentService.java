package com.topgun.airline.service;

import com.topgun.airline.domain.Payment;
import com.topgun.airline.domain.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment savePayment(Payment newPayment){
        return paymentRepository.save(newPayment);
    }

    public Payment findPaymentById(Long id){
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        return optionalPayment.orElse(null);
    }

    public List<Payment> findAllPayments(){
        return paymentRepository.findAllByActiveTrue();
    }

    public Payment updatePayment(Long id, Payment inputPayment){
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if(optionalPayment.isPresent()){
            Payment updatedPayment = optionalPayment.get();
            updatedPayment.setPaymentType(inputPayment.getPaymentType());
            updatedPayment.setUser(inputPayment.getUser());
            updatedPayment.setReservation(inputPayment.getReservation());
            updatedPayment.setValue(inputPayment.getValue());
            updatedPayment.setPayDate(inputPayment.getPayDate());
            paymentRepository.save(inputPayment);
            return updatedPayment;
        }
        return null;
    }

    public Payment deletePayment(Long id){
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if(optionalPayment.isPresent()){
            Payment payment = optionalPayment.get();
            payment.deactivatePayment();
            return paymentRepository.save(payment);
        }
        return null;
    }
}
