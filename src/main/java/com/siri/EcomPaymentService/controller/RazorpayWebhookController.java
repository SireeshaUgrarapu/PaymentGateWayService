package com.siri.EcomPaymentService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RazorpayWebhookController {
    @PostMapping("/rzp/webhook")
    public ResponseEntity<String> webhook(){
        System.out.println("razorpay webhook called ");
        return ResponseEntity.ok("OK");
    }
}
