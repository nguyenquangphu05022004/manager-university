package com.example.manageruniversity.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@MappedSuperclass
public abstract class Person  extends Base{
    private String fullName;
    private String address;
    private String username;
    private String password;
    private Date dateOfBirth;
    private Boolean sex;
}
