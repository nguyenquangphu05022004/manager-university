package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.MajorRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MajorRegisterRepository extends JpaRepository<MajorRegister, Long> {

    Optional<MajorRegister> findBySeasonIdAndMajorId(Long seasonId, Long majorId);
    MajorRegister findByMajorIdAndSeasonDisabled(Long majorId, boolean disabled);
    @Query("select mr from MajorRegister mr inner join Major m on mr.major.id = m.id " +
            "inner join Student st on m.id = st.major.id " +
            "where st.id = :studentId")
    List<MajorRegister> findAllByStudentId(@Param("studentId") Long studentId);


    @Query("select mr from Season s inner join MajorRegister mr on s.id = mr.season.id inner join Major m on mr.major.id = m.id " +
            "inner join Student st on m.id = st.major.id " +
            "where st.id = :studentId and s.disabled = false and mr.openRegister = :openRegister")
    Optional<MajorRegister> findByStudentIdAndSeasonNotDisabledAndOpenRegister(Long studentId, boolean openRegister);
}
