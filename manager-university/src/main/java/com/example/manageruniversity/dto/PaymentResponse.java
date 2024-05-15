package com.example.manageruniversity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PaymentResponse {
    private String description;
    private String transactionId;
    private Integer amountPaid;
    private boolean complete;
}
