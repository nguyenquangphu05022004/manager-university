package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Data
public class MajorRegisterDTO extends BaseDTO {
    private List<SubjectDTO> subjectDTOS = new ArrayList<>();
    private MajorDTO majorDTO;
    private SeasonDTO seasonDTO;
    private TuitionDTO tuitionDTO;
    private List<RegisterDTO> registerDTOS = new ArrayList<>();
    private boolean openRegister;
    private PaymentResponse paymentOfPerStudentAtCurrentSeason;
    public Integer getTotalCreditOfStudent() {
        var t = 0;
        for(var s : registerDTOS) {
            t += s.getSubjectGroup().getSubject().getCredit();
        }
        return t;
    }
    public Integer getTotalCreditOfMajor() {
        var t = 0;
        for(var s : subjectDTOS) {
            t += s.getCredit();
        }
        return t;
    }
    public Integer getTotalPrice() {
        int t = 0;
        for(var r : registerDTOS) {
            if(tuitionDTO != null) {
                t += tuitionDTO.getMoneyPerCredit() * r.getSubjectGroup().getSubject().getCredit();
            }
        }
        return t;
    }
    public double getSeasonGradeAverage() {
        if(registerDTOS.size() == 0) return 0;
        double a = 0;
        for(int i = 0; i < registerDTOS.size(); i++) {
            RegisterDTO r = registerDTOS.get(i);
            if(r.getGrade() != null) {
                a += r.getGrade().getSubjectAverage();
            }
        }
        return a/(registerDTOS.size());
    }
}
