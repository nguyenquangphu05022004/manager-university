package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Data
public class MajorDTO extends BaseDTO{
    private String name;
    private String sub;
    private List<MajorRegisterDTO> majorRegisterDTOS = new ArrayList<>();
}
