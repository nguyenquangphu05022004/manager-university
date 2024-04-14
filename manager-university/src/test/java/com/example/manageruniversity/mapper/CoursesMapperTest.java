package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.CoursesDTO;
import com.example.manageruniversity.entity.Courses;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CoursesMapperTest {

    @Test
    void coursesToDTOIsCorrect() {
        //given
        Courses courses = new Courses();
        courses.setId(1l);
        courses.setName("2022-2027");
        courses.setCode("D22");
        //when
        CoursesDTO coursesDTO = CoursesMapper.mapper.coursesToDTO(courses);

        assertThat(coursesDTO.getCode()).isEqualTo(courses.getCode());
        assertThat(coursesDTO.getName()).isEqualTo(courses.getName());
        assertThat(coursesDTO.getId()).isEqualTo(courses.getId());

    }

    @Test
    void coursesDTOtoEntity() {
        CoursesDTO coursesDTO = new CoursesDTO();
        coursesDTO.setCode("D22");
        coursesDTO.setName("2022-2027");

        Courses courses = CoursesMapper.mapper.coursesDTOtoEntity(coursesDTO);
        assertThat(courses.getName()).isEqualTo(coursesDTO.getName());
        assertThat(courses.getCode()).isEqualTo(coursesDTO.getCode());
        assertThat(courses.getSeasons().size()).isEqualTo(0);

        Courses courses1 = new Courses();
        courses1.setCode("testCode");
        courses1.setName("testName");

//        Courses courses2 = CoursesMapper.mapper.coursesDTOToEntity(courses1, coursesDTO);

//        assertThat(courses2.getName()).isEqualTo(coursesDTO.getName());


    }
}