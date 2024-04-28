package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.TuitionDTO;
import com.example.manageruniversity.entity.Tuition;
import com.example.manageruniversity.mapper.TuitionMapper;
import com.example.manageruniversity.repository.TuitionRepository;
import com.example.manageruniversity.service.ITuitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TuitionServiceImpl implements ITuitionService {
    private final TuitionRepository tuitionRepository;

    @Override
    public void saveOrUpdate(TuitionDTO tuitionDTO) {
        Tuition tuition = null;
        if (tuitionDTO.getId() != null) {

        } else {
            tuition = TuitionMapper.mapper.dtoToEntity(tuitionDTO);
        }
        tuitionRepository.save(tuition);
    }

    @Override
    public List<TuitionDTO> listTuition() {
        List<Tuition> tuitions = tuitionRepository.findAll();
        return tuitions.stream().map(tuition -> {
            return TuitionMapper.mapper.entityToDto(tuition);
        }).toList();
    }
}
