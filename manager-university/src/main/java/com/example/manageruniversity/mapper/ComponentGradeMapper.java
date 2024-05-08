package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.ComponentGradeDTO;
import com.example.manageruniversity.entity.ComponentGrade;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComponentGradeMapper {
    ComponentGradeMapper mapper = Mappers.getMapper(ComponentGradeMapper.class);
    ComponentGrade toEntity(ComponentGradeDTO componentGradeDTO);

    ComponentGradeDTO toDto(ComponentGrade componentGrade);
}
