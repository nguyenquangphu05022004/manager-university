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

    @Query(value = "select\n" +
            "r.*\n" +
            "from students st inner join registers r on st.id = r.student_id inner join subject_group sg\n" +
            "    on r.subject_group_id = sg.id\n" +
            "    inner join subjects s\n" +
            "    on s.id = sg.subject_id\n" +
            "    inner join major_register_subject mrs\n" +
            "    on s.id = mrs.subject_id\n" +
            "    inner join major_registers mr\n" +
            "    on mrs.major_register_id = mr.id\n" +
            "    inner join seasons sea\n" +
            "    on mr.season_id = sea.id\n" +
            "where st.id = :studentId sea.disabled = false\n",
            nativeQuery = true)
    List<Register> findAllByStudentIdAndSeasonNotDisabled(@Param("studentId") Long studentId);

    @Query("select r from Student s inner join Register r on s.id = r.student.id inner join SubjectGroup  sg on r.subjectGroup.id=sg.id " +
            "inner join Subject sj on sg.subject.id= sj.id " +
            "where sj.id = :subjectId and s.id != :studentId and r.openTransaction = true")
    List<Register> findAllRegisterOpenedBySubjectIdAndNotOfStudentId(@Param("subjectId") Long subjectId,
                                                                     @Param("studentId") Long studentId);

    List<Register> findAllByMajorRegisterId(Long majorRegisterId);
    List<Register> findAllByStudentIdAndMajorRegisterId(Long studentId, Long majorRegisterId);

    @Query(value = "select\n" +
            "r.*\n" +
            "from registers r inner join subject_group sg\n" +
            "    on r.subject_group_id = sg.id\n" +
            "    inner join subjects s\n" +
            "    on s.id = sg.subject_id\n" +
            "    inner join major_register_subject mrs\n" +
            "    on s.id = mrs.subject_id\n" +
            "    inner join major_registers mr\n" +
            "    on mrs.major_register_id = mr.id\n" +
            "    inner join seasons sea\n" +
            "    on mr.season_id = sea.id\n" +
            "where sg.id = :subjectGroupId and mr.id = r.major_register_id and sea.disabled = false\n",
    nativeQuery = true)
    List<Register> findAllBySubjectGroupIdAndSeasonNotDisabled(@Param("subjectGroupId") Long subjectGroupId);

}
