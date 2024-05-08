package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.util.backoff.BackOff;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface SeasonRepository extends JpaRepository<Season, Long> {

    List<Season> findAllByDisabled(boolean disabled);
    @Query("select s from Season s inner join Courses c on s.courses.id = c.id " +
            "where c.id = :coursesId " +
            "order by s.id desc ")
    List<Season> findAllByCoursesIdAndOrderByIdDesc(@PathVariable("coursesId") Long coursesId);
}
