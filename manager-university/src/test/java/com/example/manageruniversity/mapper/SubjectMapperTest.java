package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.dto.SubjectGroupDTO;
import com.example.manageruniversity.entity.Subject;
import com.example.manageruniversity.entity.Tuition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SubjectMapperTest {

    @Test
    void subjectToDTO_is_correct() {
        Subject subject = new Subject();
        subject.setSubjectCode("BAS102");
        subject.setSubjectName("Tu tuong hcm");
        subject.setId(1l);
        subject.setCredit(2);

        SubjectGroupDTO subjectGroupDTO = new SubjectGroupDTO();

        Tuition tuition = new Tuition();
        tuition.setMoneyPerCredit(650000);
        subject.setTuition(tuition);

        SubjectDTO subjectDTO = SubjectMapper.mapper.subjectToDTO(subject);
        System.out.println(subjectDTO);
        assertThat(subjectDTO.getSubjectCode()).isEqualTo(subjectDTO.getSubjectCode());
        assertThat(subjectDTO.getTuitionDTO()).isNotNull();
        assertThat(subjectDTO.getTuitionDTO().getMoneyPerCredit()).isEqualTo(tuition.getMoneyPerCredit());
    }
}