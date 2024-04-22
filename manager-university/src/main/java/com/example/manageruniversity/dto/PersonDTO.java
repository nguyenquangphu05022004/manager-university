package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;

import java.util.Date;
@Getter
@Data
public class PersonDTO extends BaseDTO {
    private String fullName;
    private String address;
    private String phoneNumber;
    private String email;
    private Date dateOfBirth;
    private Boolean sex;
}
