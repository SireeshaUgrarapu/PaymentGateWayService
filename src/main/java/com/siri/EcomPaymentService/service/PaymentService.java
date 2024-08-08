package com.siri.EcomPaymentService.service;

import com.razorpay.RazorpayException;
import com.siri.EcomPaymentService.PaymentRequestDTO;

public interface PaymentService {
    String generatePaymentLink(PaymentRequestDTO paymentRequestDTO) throws RazorpayException;
}
