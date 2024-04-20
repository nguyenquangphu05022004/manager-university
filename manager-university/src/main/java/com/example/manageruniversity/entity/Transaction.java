package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends Base {
    @ManyToOne
    @JoinColumn(name = "register_id")
    private Register targetRegister;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;




}
