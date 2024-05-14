package com.example.manageruniversity.controller;

import com.example.manageruniversity.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class TransactionController {

    private final ITransactionService transactionService;

    @PostMapping("/transactions")
    public ResponseEntity<?> createTransaction(@RequestParam("targetRegisterId") Long targetRegisterId,
                                            @RequestParam("studentId") Long studentId) {
        transactionService.save(targetRegisterId, studentId);
        return ResponseEntity.ok("Success create transaction");
    }
    @DeleteMapping("/transactions")
    public void deleteTransaction(@RequestParam("targetRegisterId") Long targetRegister,
                                  @RequestParam("studentRequestId") Long studentRequestId) {
        transactionService.deleteByRegisterIdAndStudentId(targetRegister, studentRequestId);
    }
    @PostMapping("/transactions/confirm")
    public ResponseEntity<?> confirmTransaction(@RequestParam("targetRegisterId") Long targetRegisterId,
                                               @RequestParam("requestRegisterId") Long requestRegisterId) {
        transactionService.confirmTransaction(targetRegisterId, requestRegisterId);
        return ResponseEntity.ok("Success create transaction");
    }
}
