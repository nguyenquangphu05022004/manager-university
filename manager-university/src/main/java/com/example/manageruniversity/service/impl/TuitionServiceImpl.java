package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.TuitionDTO;
import com.example.manageruniversity.entity.Season;
import com.example.manageruniversity.entity.Tuition;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.mapper.TuitionMapper;
import com.example.manageruniversity.repository.MajorRegisterRepository;
import com.example.manageruniversity.repository.SeasonRepository;
import com.example.manageruniversity.repository.TuitionRepository;
import com.example.manageruniversity.service.ITuitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TuitionServiceImpl implements ITuitionService {
    private final TuitionRepository tuitionRepository;
    private final MajorRegisterRepository majorRegisterRepository;

    @Override
    public void initTuition(TuitionDTO tuitionDTO) {
        var majorRegister = majorRegisterRepository
                .findById(tuitionDTO.getMajorRegisterDTO().getId())
                .orElseThrow(() -> new NotFoundIdException("MajorRegister", "ID",
                        tuitionDTO.getMajorRegisterDTO().getId().toString()));
        if(majorRegister.getTuition() == null) {
            Tuition tuition = new Tuition();
            tuition.setMoneyPerCredit(tuitionDTO.getMoneyPerCredit());
            tuition.setMajorRegister(majorRegister);
            tuitionRepository.save(tuition);
        }
    }

    @Override
    public List<TuitionDTO> listTuition() {
        List<Tuition> tuitions = tuitionRepository.findAll();
        return tuitions.stream().map(tuition -> {
            return TuitionMapper.mapper.entityToDto(tuition);
        }).toList();
    }
}
