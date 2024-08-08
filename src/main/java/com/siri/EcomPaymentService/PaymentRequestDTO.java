package com.siri.EcomPaymentService;

import lombok.Getter;
import lombok.Lombok;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequestDTO {
    private long amount;
    private String orderId;
    private String description;
    private String customerName;
    private String customerPhoto;
    private String customerEmail;

}
