package com.example.manageruniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "tuition")
@Data
@Getter
public class Tuition extends Base{
    private Integer moneyPerCredit;
    @OneToOne(mappedBy = "tuition")
    private Subject subject;
}
