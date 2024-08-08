package com.siri.EcomPaymentService.controller;

import com.razorpay.RazorpayException;
import com.siri.EcomPaymentService.PaymentRequestDTO;
import com.siri.EcomPaymentService.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<String> doPayment(@RequestBody PaymentRequestDTO paymentRequestDTO) throws RazorpayException {
        return ResponseEntity.ok(paymentService.generatePaymentLink(paymentRequestDTO));
    }
    @GetMapping("/hello/{name}")
    public ResponseEntity<String> hello(@PathVariable("name") String name){
        System.out.println("Hello word,from sireesha computer : "+name);
        return ResponseEntity.ok("Hello word,from sireesha computer : "+name);
    }
}
