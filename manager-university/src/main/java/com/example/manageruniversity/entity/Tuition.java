package com.example.manageruniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tuition")
public class Tuition extends Base{
    private Integer moneyPerCredit;
    @OneToOne(mappedBy = "tuition")
    private Subject subject;
}
