package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
}
