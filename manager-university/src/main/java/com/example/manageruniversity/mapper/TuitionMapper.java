package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.TuitionDTO;
import com.example.manageruniversity.entity.Tuition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TuitionMapper {
    TuitionMapper mapper = Mappers.getMapper(TuitionMapper.class);

    TuitionDTO entityToDto(Tuition tuition);
    Tuition dtoToEntity(TuitionDTO tuitionDTO);
}
