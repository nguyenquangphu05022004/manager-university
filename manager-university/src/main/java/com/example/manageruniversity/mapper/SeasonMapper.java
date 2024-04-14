package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.SeasonDTO;
import com.example.manageruniversity.entity.Season;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeasonMapper {
    SeasonMapper mapper = Mappers.getMapper(SeasonMapper.class);

    Season seasonDTOToEntity(SeasonDTO seasonDTO);
    SeasonDTO seasonToDTO(Season season);
}
