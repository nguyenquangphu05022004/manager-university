package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tuition")
@Data
@Getter
public class Tuition extends Base{
    private Integer moneyPerCredit;
    @OneToOne
    @JoinColumn(name = "major_register_id")
    private MajorRegister majorRegister;
}
