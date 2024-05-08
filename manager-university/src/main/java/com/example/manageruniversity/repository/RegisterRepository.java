package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface RegisterRepository extends JpaRepository<Register, Long> {
    Optional<Register> findByStudentUserUsernameAndSubjectGroupSubjectSubjectCode(String studentCode, String subjectCode);

    List<Register> findAllByOpenTransaction(boolean transaction);

    List<Register> findAllByStudentIdAndMajorRegisterSeasonDisabled(Long studentId, boolean disabled);


    @Query("select r from Student s inner join Register r on s.id = r.student.id inner join SubjectGroup  sg on r.subjectGroup.id=sg.id " +
            "inner join Subject sj on sg.subject.id= sj.id " +
            "where sj.id = :subjectId and s.id != :studentId and r.openTransaction = true")
    List<Register> findAllRegisterOpenedBySubjectIdAndNotOfStudentId(@Param("subjectId") Long subjectId,
                                                                     @Param("studentId") Long studentId);

    List<Register> findAllByMajorRegisterId(Long majorRegisterId);
    List<Register> findAllByStudentIdAndMajorRegisterId(Long studentId, Long majorRegisterId);
}
