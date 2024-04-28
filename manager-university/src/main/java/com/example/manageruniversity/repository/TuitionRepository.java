package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Tuition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuitionRepository extends JpaRepository<Tuition, Long> {
}
