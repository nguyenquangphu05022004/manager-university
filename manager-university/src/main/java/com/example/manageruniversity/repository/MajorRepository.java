package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRepository extends JpaRepository<Major, Long> {
}
