package com.siri.EcomPaymentService.service;

import com.razorpay.RazorpayClient;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import com.siri.EcomPaymentService.PaymentRequestDTO;
import com.siri.EcomPaymentService.config.RazorpayClientConfig;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    private RazorpayClientConfig razorpayClientConfig;
    @Override
    public String generatePaymentLink(PaymentRequestDTO paymentRequestDTO) throws RazorpayException{
        RazorpayClient razorpay = razorpayClientConfig.getRazorpayClient();
        JSONObject paymentLinkRequest =new JSONObject();
        paymentLinkRequest.put("amount",paymentRequestDTO.getAmount());
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",false);
        paymentLinkRequest.put("expire_by", Instant.now().toEpochMilli() +600000);
        paymentLinkRequest.put("reference_id",paymentRequestDTO.getOrderId());
        paymentLinkRequest.put("description",paymentRequestDTO.getDescription());

        JSONObject customer = new JSONObject();
        customer.put("name",paymentRequestDTO.getCustomerName());
        customer.put("contact",paymentRequestDTO.getCustomerPhoto());
        customer.put("email",paymentRequestDTO.getCustomerEmail());
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("notify",notify);
        paymentLinkRequest.put("remainder_enable",true);

        PaymentLink payment = razorpay.paymentLink.create(paymentLinkRequest);

        return payment.toString();
    }
}
