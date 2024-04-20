package com.example.manageruniversity.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

@MappedSuperclass
@Getter
@Data
public abstract class Person extends Base {
    private String fullName;
    private String address;
    private String phoneNumber;
    private String email;
    private Date dateOfBirth;
    private Boolean sex;
}
