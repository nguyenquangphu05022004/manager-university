package com.example.manageruniversity.controller;

import com.example.manageruniversity.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final ITransactionService transactionService;

    @PostMapping("/api/transactions")
    public ResponseEntity<?> createTransaction(@RequestParam("targetRegisterId") Long targetRegisterId,
                                            @RequestParam("studentId") Long studentId) {
        transactionService.save(targetRegisterId, studentId);
        return ResponseEntity.ok("Success create transaction");
    }

    @PostMapping("/api/transactions/confirm")
    public ResponseEntity<?> confirmTransaction(@RequestParam("targetRegisterId") Long targetRegisterId,
                                               @RequestParam("requestRegisterId") Long requestRegisterId) {
        transactionService.confirmTransaction(targetRegisterId, requestRegisterId);
        return ResponseEntity.ok("Success create transaction");
    }
}
