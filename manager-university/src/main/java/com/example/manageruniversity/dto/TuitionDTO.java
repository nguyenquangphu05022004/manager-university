package com.example.manageruniversity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TuitionDTO extends BaseDTO{
    private Integer moneyPerCredit;
    private MajorRegisterDTO majorRegisterDTO;
}
