package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MajorRepository extends JpaRepository<Major, Long> {
}
