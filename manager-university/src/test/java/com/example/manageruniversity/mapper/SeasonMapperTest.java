package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.SeasonDTO;
import com.example.manageruniversity.dto.SemesterDTO;
import com.example.manageruniversity.entity.Season;
import com.example.manageruniversity.entity.Semester;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SeasonMapperTest {

    @Test
    void seasonDTOToEntity() {
        SemesterDTO semesterDTO = new SemesterDTO();
        semesterDTO.setSemesterName("Hoc ky 2");
        semesterDTO.setId(2l);

        SeasonDTO seasonDTO = new SeasonDTO();
        seasonDTO.setSemester(semesterDTO);

        Season season = SeasonMapper.mapper.seasonDTOToEntity(seasonDTO);

        assertThat(season.getSemester()).isNotNull();
        assertThat(season.getSemester().getSemesterName()).isEqualTo(semesterDTO.getSemesterName());
    }

    @Test
    void seasonToDTO() {
    }
}