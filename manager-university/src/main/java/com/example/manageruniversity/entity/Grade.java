package com.example.manageruniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "grades")
@Getter
@Data
public class Grade extends Base{
    @OneToOne
    @JoinColumn(name = "register_id")
    private Register register;
}
