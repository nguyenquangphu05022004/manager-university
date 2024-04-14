package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.SeasonDTO;
import com.example.manageruniversity.entity.Season;
import com.example.manageruniversity.mapper.SeasonMapper;
import com.example.manageruniversity.repository.SeasonRepository;
import com.example.manageruniversity.service.ISeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeasonServiceImpl implements ISeasonService {
    private final SeasonRepository seasonRepository;

    @Autowired
    public SeasonServiceImpl(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public SeasonDTO saveOrUpdate(SeasonDTO seasonDTO) {
        Season season = null;
        if(seasonDTO.getId() != null) {

        } else {
            season = SeasonMapper.mapper.seasonDTOToEntity(seasonDTO);
        }
        season = seasonRepository.save(season);
        return SeasonMapper.mapper.seasonToDTO(season);
    }

    @Override
    public List<SeasonDTO> records() {
        List<Season> seasons = seasonRepository.findAll();
        return seasons.stream().map(season -> {
            return SeasonMapper.mapper.seasonToDTO(season);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        seasonRepository.deleteById(id);
    }
}
