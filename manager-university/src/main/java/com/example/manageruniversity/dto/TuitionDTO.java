package com.example.manageruniversity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TuitionDTO extends BaseDTO{
    private Integer moneyPerCredit;
    private List<SubjectDTO> subjects = new ArrayList<>();
    private SeasonDTO seasonDTO;

    public Integer getTotalPrice() {
        int total = 0;
        for(int i = 0; i < subjects.size(); i++) {
            total += subjects.get(i).getCredit() * moneyPerCredit;
        }
        return total;
    }
    public Integer getTotalCredit() {
        int total = 0;
        for(int i = 0; i < subjects.size(); i++) {
            total += subjects.get(i).getCredit();
        }
        return total;
    }

}
