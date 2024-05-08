package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.MajorRegisterDTO;
import com.example.manageruniversity.entity.MajorRegister;
import com.example.manageruniversity.entity.Register;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.mapper.MajorRegisterMapper;
import com.example.manageruniversity.mapper.SeasonMapper;
import com.example.manageruniversity.repository.MajorRegisterRepository;
import com.example.manageruniversity.repository.RegisterRepository;
import com.example.manageruniversity.service.IMajorRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MajorRegisterServiceImpl implements IMajorRegisterService {
    private final MajorRegisterRepository majorRegisterRepository;
    private final RegisterRepository registerRepository;

    @Override
    public MajorRegisterDTO saveOrUpdate(MajorRegisterDTO majorRegisterDTO) {
        MajorRegister majorRegister = null;
        if(majorRegisterDTO.getId() != null) {
        } else {
            majorRegister = MajorRegisterMapper.mapper.majorRegisterDTOToEntity(majorRegisterDTO);
        }
        majorRegister = majorRegisterRepository.save(majorRegister);
        return majorRegisterDTO;
    }

    @Override
    public List<MajorRegisterDTO> records() {
        List<MajorRegister> majorRegisters = majorRegisterRepository.findAll();
        return majorRegisters.stream().map(majorRegister -> {
            MajorRegisterDTO majorRegisterDTO = MajorRegisterMapper.mapper
                    .majorRegisterToDTO(majorRegister);
            var re = majorRegister.getSeason(); re.setMajorRegisters(new ArrayList<>());
            majorRegisterDTO.setSeasonDTO(SeasonMapper.mapper.seasonToDTO(re));
            return majorRegisterDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        majorRegisterRepository.deleteById(id);
    }

    @Override
    public MajorRegisterDTO findByMajorIdAndSeasonDisabled(Long majorId, boolean disabled) {
        MajorRegister majorRegister = majorRegisterRepository.findByMajorIdAndSeasonDisabled(majorId, disabled);
        return MajorRegisterMapper.mapper.majorRegisterToDTO(majorRegister);
    }

    @Override
    public List<MajorRegisterDTO> findAllByStudentId(Long studentId) {
        List<MajorRegister> majorRegisters = majorRegisterRepository.findAllByStudentId(studentId);
        for(MajorRegister m : majorRegisters) {
            List<Register> registers = registerRepository.findAllByStudentIdAndMajorRegisterId(studentId, m.getId());
            m.setRegisters(registers);
        }
        return majorRegisters.stream()
                .map(majorRegister -> MajorRegisterMapper.mapper.majorRegisterToDTO(majorRegister))
                .toList();
    }

    @Override
    public MajorRegisterDTO findByStudentIdAndSeasonNotDisabledAndOpenRegister(Long studentId, boolean openRegister) {
        MajorRegister majorRegister = majorRegisterRepository.findByStudentIdAndSeasonNotDisabledAndOpenRegister(studentId, openRegister)
                .orElseThrow(() -> new NotFoundIdException("MajorRegister", "StudentId - OpenRegister", studentId + " - " + openRegister));
        List<Register> registers = registerRepository.findAllByStudentIdAndMajorRegisterId(studentId, majorRegister.getId());
        majorRegister.setRegisters(registers);
        return MajorRegisterMapper.mapper.majorRegisterToDTO(majorRegister);
    }
}
