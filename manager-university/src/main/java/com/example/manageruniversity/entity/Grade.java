package com.example.manageruniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "grades")
public class Grade extends Base{
    @OneToOne
    @JoinColumn(name = "register_id")
    private Register register;
}
