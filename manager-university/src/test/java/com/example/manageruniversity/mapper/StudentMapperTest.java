package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.MajorDTO;
import com.example.manageruniversity.dto.StudentDTO;
import com.example.manageruniversity.entity.Student;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    @Test
    void studentDTOToEntity() {
        MajorDTO majorDTO = new MajorDTO();
        majorDTO.setName("Cong nghe thong tin");
        majorDTO.setSub("CNTT");
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setAddress("Bac Ninh");
        studentDTO.setMajorDTO(majorDTO);

        Student student = StudentMapper.mapper.studentDTOToEntity(studentDTO);

        assertThat(student.getAddress()).isEqualTo(studentDTO.getAddress());
        assertThat(student.getMajor()).isNotNull();
        assertThat(student.getMajor().getSub()).isEqualTo(majorDTO.getSub());
    }

    @Test
    void studentEntityTodTO() {
    }
}