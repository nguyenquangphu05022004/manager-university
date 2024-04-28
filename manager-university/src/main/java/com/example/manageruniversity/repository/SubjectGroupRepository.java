package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.SubjectGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectGroupRepository extends JpaRepository<SubjectGroup, Long> {
    List<SubjectGroup> findAllBySubjectId(Long subjectId);
}
