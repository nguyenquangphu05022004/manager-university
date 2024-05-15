package com.example.manageruniversity.service;

public interface IPaymentService {
    void save(String description,
              String transactionPaymentId,
              int totalPrice);
}
