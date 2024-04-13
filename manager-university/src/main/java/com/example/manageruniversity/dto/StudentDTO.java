package com.example.manageruniversity.dto;

import com.example.manageruniversity.entity.Major;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
public class StudentDTO extends PersonDTO {
    private MajorDTO majorDTO;
}
