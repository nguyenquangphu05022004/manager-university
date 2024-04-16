package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
