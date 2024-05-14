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


    @Query(value = "select\n" +
            "    st.*\n" +
            "from students st inner join registers r on st.id = r.student_id\n" +
            "    inner join subject_group sg on r.subject_group_id = sg.id\n" +
            "    inner join subjects s on sg.subject_id = s.id inner join major_register_subject mrr\n" +
            "    on s.id = mrr.subject_id inner join major_registers mr on mrr.major_register_id = mr.id\n" +
            "    inner join seasons sea on sea.id = mr.season_id\n" +
            "where sg.id = :subjectGroupId and mr.id = r.major_register_id and sea.disabled = false", nativeQuery = true)
    List<Student> findAllBySubjectGroupId(@Param("subjectGroupId") Long subjectGroupId);

}
