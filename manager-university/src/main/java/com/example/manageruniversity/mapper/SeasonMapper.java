package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.MajorRegisterDTO;
import com.example.manageruniversity.dto.SeasonDTO;
import com.example.manageruniversity.dto.SubjectDTO;
import com.example.manageruniversity.entity.MajorRegister;
import com.example.manageruniversity.entity.Season;
import com.example.manageruniversity.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeasonMapper {
    SeasonMapper mapper = Mappers.getMapper(SeasonMapper.class);


    Season seasonDTOToEntity(SeasonDTO seasonDTO);

    @Mapping(target = "majorRegisterDTOS", source = "season.majorRegisters")
    SeasonDTO seasonToDTO(Season season);
    SubjectDTO subjectToDto(Subject subject);
}
