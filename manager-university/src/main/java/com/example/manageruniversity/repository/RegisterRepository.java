package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RegisterRepository extends JpaRepository<Register, Long> {
    List<Register> findAllByStudentId(Long studentId);
    List<Register> findAllByOpenTransaction(boolean transaction);

    //find all list in season specific
    @Query("select " +
            " r " +
            "from Register r inner join Student st on r.student.id = st.id\n" +
            "    inner join Major mj on st.major.id = mj.id inner join MajorRegister mj_re\n" +
            "    on mj.id = mj_re.major.id inner join Season sea on mj_re.season.id = sea.id\n" +
            "where st.id= :studentId and sea.disabled= :disabled")
    List<Register> findAll(@Param("studentId") Long studentId,
                           @Param("disabled") boolean disabled);

    @Query("select r from Student s inner join Register r on s.id = r.student.id inner join SubjectGroup  sg on r.subjectGroup.id=sg.id " +
            "inner join Subject sj on sg.subject.id= sj.id " +
            "where sj.id = :subjectId and s.id != :studentId and r.openTransaction = true")
    List<Register> findAllRegisterOpenedBySubjectIdAndNotOfStudentId(@Param("subjectId") Long subjectId,
                                                                   @Param("studentId") Long studentId);
}
