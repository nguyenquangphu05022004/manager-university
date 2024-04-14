package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.SchoolYearDTO;
import com.example.manageruniversity.entity.SchoolYear;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SchoolYearMapper {
    SchoolYearMapper mapper = Mappers.getMapper(SchoolYearMapper.class);

    SchoolYear schoolYearDTOToEntity(SchoolYearDTO schoolYearDTO);
    SchoolYearDTO schoolYearToDTO(SchoolYear schoolYear);

}
