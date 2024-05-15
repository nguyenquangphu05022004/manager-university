package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByStudentIdAndMajorRegisterId(Long studentId, Long majorRegisterId);
}
