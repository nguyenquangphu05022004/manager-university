package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    //delete request from different student
    void deleteAllByTargetRegisterId(Long targetRegisterId);

    //delete request of student with id to all different student
    @Modifying
    @Query("delete from Transaction " +
            "where exists (select 1 from Register r inner join SubjectGroup sg on r.subjectGroup.id = sg.id inner join Subject s on sg.subject.id=s.id where s.id = :subjectId) and " +
            "student.id = :studentId")
    void deleteAllRequest(@Param("studentId") Long studentId,@Param("subjectId") Long subjectId);


}
