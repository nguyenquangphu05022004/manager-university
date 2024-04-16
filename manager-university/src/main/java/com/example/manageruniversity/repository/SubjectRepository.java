package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
