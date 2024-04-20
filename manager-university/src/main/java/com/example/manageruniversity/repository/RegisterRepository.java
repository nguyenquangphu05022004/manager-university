package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RegisterRepository extends JpaRepository<Register, Long> {
    List<Register> findAllByStudentId(Long studentId);

    List<Register> findAllByOpenTransaction(boolean transaction);
}
