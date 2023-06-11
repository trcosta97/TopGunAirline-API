package com.topgun.airline.controller;

import com.topgun.airline.domain.Reservation;
import com.topgun.airline.domain.payment.Payment;
import com.topgun.airline.domain.payment.PaymentDTO;
import com.topgun.airline.service.PaymentService;
import jdk.javadoc.doclet.Reporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<Payment> save(@RequestBody PaymentDTO data){
        var payment = new Payment(data);
        return ResponseEntity.ok(paymentService.savePayment(payment));
    }

    @GetMapping("payment/{id}")
    public ResponseEntity<Payment> getById(@RequestParam Long id){
        return ResponseEntity.ok(paymentService.findPaymentById(id));
    }

    @GetMapping("payment")
    public ResponseEntity<List<Payment>> getAll(){
        return ResponseEntity.ok(paymentService.findAllPayments());
    }

    @PutMapping("payment/{id}")
    public ResponseEntity<Payment> update(@RequestBody PaymentDTO data, @RequestParam Long id){
        var paymentData = new Payment(data);
        Payment updatedPayment = paymentService.updatePayment(id, paymentData);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("payment/{id}")
    public ResponseEntity<Payment> delete(@RequestParam Long id){
        return ResponseEntity.ok(paymentService.deletePayment(id));
    }

}
