package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.TestScheduleDTO;
import com.example.manageruniversity.entity.Student;
import com.example.manageruniversity.entity.TestSchedule;
import com.example.manageruniversity.mapper.RoomClassMapper;
import com.example.manageruniversity.mapper.SeasonMapper;
import com.example.manageruniversity.mapper.SubjectMapper;
import com.example.manageruniversity.repository.StudentRepository;
import com.example.manageruniversity.repository.TestScheduleRepository;
import com.example.manageruniversity.service.ITestScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestScheduleServiceImpl implements ITestScheduleService {
    private final TestScheduleRepository testScheduleRepository;
    private final StudentRepository studentRepository;

    @Override
    public void saveOrUpdate(TestScheduleDTO testScheduleDTO) {
        Pageable pageable = PageRequest.of(testScheduleDTO.getRoomNumber() - 1, testScheduleDTO.getNumberOfStudent());
        Page<Student> studentPage = studentRepository
                .findAllBySubjectId(testScheduleDTO.getSubject().getId(),
                        pageable);
        Optional<TestSchedule> optionalTestSchedule = testScheduleRepository
                .findBySeasonId(testScheduleDTO
                        .getSeasonDTO()
                        .getId());
        TestSchedule schedule = new TestSchedule();
//        if(optionalTestSchedule.isPresent()) {
//
//        } else {
//            schedule = mapToEntity(testScheduleDTO);
//            schedule.setStudents(students);
//        }
//        testScheduleRepository.save(schedule);
    }

    @Override
    public List<TestScheduleDTO> getListBySeasonIdAndStudentId(Long seasonId, Long studentId) {
        List<TestSchedule> testSchedules = testScheduleRepository.findAllBySeasonIdAndStudentId(seasonId, studentId);
        return testSchedules.stream().map(this::mapToDto).toList();
    }

    private TestScheduleDTO mapToDto(TestSchedule schedule) {
        TestScheduleDTO testSchedule = TestScheduleDTO.builder()
                .seasonDTO(SeasonMapper.mapper.seasonToDTO(schedule.getSeason()))
                .startDate(schedule.getStartDate())
                .startTime(schedule.getStartTime())
                .endTime(schedule.getEndTime())
                .numberOfStudent(schedule.getNumberOfStudent())
                .roomNumber(schedule.getRoomNumber())
                .testType(schedule.getTestType())
                .roomClass(RoomClassMapper.mapper.roomClassToDTO(schedule.getRoomClass()))
                .subject(SubjectMapper.mapper.subjectToDTO(schedule.getSubject()))
                .build();
        return testSchedule;
    }

    private TestSchedule mapToEntity(TestScheduleDTO testScheduleDTO) {
        TestSchedule studentsTestRoom = TestSchedule.builder()
                .season(SeasonMapper.mapper.seasonDTOToEntity(testScheduleDTO.getSeasonDTO()))
                .startDate(testScheduleDTO.getStartDate())
                .startTime(testScheduleDTO.getStartTime())
                .endTime(testScheduleDTO.getEndTime())
                .numberOfStudent(testScheduleDTO.getNumberOfStudent())
                .roomNumber(testScheduleDTO.getRoomNumber())
                .testType(testScheduleDTO.getTestType())
                .roomClass(RoomClassMapper.mapper.roomClassDTOToEntity(testScheduleDTO.getRoomClass()))
                .subject(SubjectMapper.mapper.subjectDTOToEntity(testScheduleDTO.getSubject()))
                .build();
        return studentsTestRoom;
    }
}
