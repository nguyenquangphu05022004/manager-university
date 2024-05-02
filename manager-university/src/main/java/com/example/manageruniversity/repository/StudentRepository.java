package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select st from Student st inner join Register r on st.id=r.student.id " +
            "inner join SubjectGroup sg on r.subjectGroup.id = sg.id " +
            "inner join Subject s on sg.subject.id = s.id " +
            "where s.id = :subjectId")
    Page<Student> findAllBySubjectId(@Param("subjectId") Long subjectId, Pageable pageable);
}
