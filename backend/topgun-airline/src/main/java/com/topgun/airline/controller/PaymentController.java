package com.topgun.airline.controller;

import com.topgun.airline.domain.payment.Payment;
import com.topgun.airline.domain.payment.PaymentDTO;
import com.topgun.airline.domain.reservation.Reservation;
import com.topgun.airline.service.PaymentService;
import com.topgun.airline.service.ReservationService;
import com.topgun.airline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReservationService reservationService;
    @Transactional
    @PostMapping("/payment")
    public ResponseEntity<Payment> save(@RequestBody PaymentDTO data){
        var user = userService.findUserById(data.userId());
        if(user == null){
            throw  new IllegalArgumentException("User not found");
        }else{
            var payment = new Payment(data);
            payment.setUser(user);
            return ResponseEntity.ok(paymentService.savePayment(payment));
        }
    }

    @GetMapping("payment/{id}")
    public ResponseEntity<Payment> getById(@RequestParam Long id){
        return ResponseEntity.ok(paymentService.findPaymentById(id));
    }

    @GetMapping("payment")
    public ResponseEntity<List<Payment>> getAll(){
        return ResponseEntity.ok(paymentService.findAllPayments());
    }
    @Transactional
    @PutMapping("payment/{id}")
    public ResponseEntity<Payment> update(@RequestBody PaymentDTO data, @RequestParam Long id){
        var paymentData = new Payment(data);
        Payment updatedPayment = paymentService.updatePayment(id, paymentData);
        return ResponseEntity.ok(updatedPayment);
    }
    @Transactional
    @DeleteMapping("payment/{id}")
    public ResponseEntity<Payment> delete(@RequestParam Long id){
        return ResponseEntity.ok(paymentService.deletePayment(id));
    }

}
