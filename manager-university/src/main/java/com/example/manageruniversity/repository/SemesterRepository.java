package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
}
