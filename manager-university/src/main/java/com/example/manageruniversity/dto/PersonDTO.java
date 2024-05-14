package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;

import java.text.SimpleDateFormat;
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

    public String getDateOfBirthString() {
        if(dateOfBirth == null) return "null";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(dateOfBirth);
    }
}
