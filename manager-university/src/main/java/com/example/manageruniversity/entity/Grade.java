package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "grades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Grade extends Base{
    @OneToOne
    @JoinColumn(name = "register_id")
    private Register register;
    private float attend;
    private float midtermTest;
    private float finalTest;
    private float practiceTest;
    @ManyToOne
    @JoinColumn(name = "component_grade_id")
    private ComponentGrade componentGrade;
}
