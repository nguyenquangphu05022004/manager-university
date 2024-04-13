package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Register;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RegisterRepository extends JpaRepository<Register, Long> {
    Page<Register> findAllBySeasonIdAndSubjectGroupSubjectId(Long seasonId, Long subjectId, Pageable pageable);
}
