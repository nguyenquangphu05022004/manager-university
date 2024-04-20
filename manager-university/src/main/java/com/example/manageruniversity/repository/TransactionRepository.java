package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    void deleteAllByTargetRegisterId(Long targetRegisterId);
}
