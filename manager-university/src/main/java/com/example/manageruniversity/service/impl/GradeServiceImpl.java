package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.ComponentGradeDTO;
import com.example.manageruniversity.dto.GradeDTO;
import com.example.manageruniversity.entity.Grade;
import com.example.manageruniversity.entity.Register;
import com.example.manageruniversity.exception.NotFoundIdException;
import com.example.manageruniversity.mapper.ComponentGradeMapper;
import com.example.manageruniversity.repository.ComponentGradeRepository;
import com.example.manageruniversity.repository.GradeRepository;
import com.example.manageruniversity.repository.RegisterRepository;
import com.example.manageruniversity.service.IGradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GradeServiceImpl implements IGradeService {

    private final GradeRepository gradeRepository;
    private final RegisterRepository registerRepository;
    private final ComponentGradeRepository componentGradeRepository;

    @Override
    public void saveOrUpdate(GradeDTO gradeDTO,
                             String subjectCode,
                             String studentCode) {
        Register register = registerRepository
                .findByStudentUserUsernameAndSubjectGroupSubjectSubjectCode(studentCode, subjectCode)
                .orElseThrow(() -> new NotFoundIdException("Register", "StudentCode - SubjectCode", studentCode + " - " + subjectCode));
        Grade grade = register.getGrade();
        grade.setComponentGrade(ComponentGradeMapper.mapper.toEntity(gradeDTO.getComponentGrade()));
        grade.setAttend(gradeDTO.getAttend());
        grade.setFinalTest(gradeDTO.getFinalTest());
        grade.setPracticeTest(gradeDTO.getPracticeTest());
        grade.setMidtermTest(gradeDTO.getMidtermTest());
        gradeRepository.save(grade);
    }

    @Override
    public List<ComponentGradeDTO> getListGradeComponent() {
        return componentGradeRepository.findAll()
                .stream()
                .map(component -> ComponentGradeMapper.mapper.toDto(component))
                .toList();
    }

    @Override
    public void initGradeByMajorRegisterId(Long majorRegister) {
        List<Register> registers = registerRepository.findAllByMajorRegisterId(majorRegister);
        registers.stream().forEach(register -> {
                    if(register.getGrade() == null) {
                        Grade grade = new Grade();
                        grade.setRegister(register);
                        gradeRepository.save(grade);
                    }
                });
    }
}
