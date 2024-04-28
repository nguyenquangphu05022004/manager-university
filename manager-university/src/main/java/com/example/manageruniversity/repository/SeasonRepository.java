package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeasonRepository extends JpaRepository<Season, Long> {
    @Query("select s from Season s inner join MajorRegister mr on s.id=mr.season.id " +
            "inner join Major m on mr.major.id = m.id inner join Student st on st.major.id = m.id " +
            "where st.id = :studentId")
    List<Season> findAllByStudentId(@Param("studentId") Long studentId);
}
