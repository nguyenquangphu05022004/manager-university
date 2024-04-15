package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
