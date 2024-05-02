package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.TestSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TestScheduleRepository extends JpaRepository<TestSchedule, Long> {
    Optional<TestSchedule> findBySeasonId(Long seasonId);
    @Query(value = "select\n" +
            "    ts.*\n" +
            "from seasons s inner join test_schedules ts\n" +
            "    on s.id = ts.season_id inner join test_schedule_student tss\n" +
            "    on ts.id = tss.test_schedule_id inner join students st\n" +
            "    on tss.student_id = st.id\n" +
            "where s.id = :seasonId and st.id = :studentId",
    nativeQuery = true)
    List<TestSchedule> findAllBySeasonIdAndStudentId(@Param("seasonId") Long seasonId,
                                                     @Param("studentId") Long studentId);
}
