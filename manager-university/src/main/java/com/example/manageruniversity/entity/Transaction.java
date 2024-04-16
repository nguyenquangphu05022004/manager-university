package com.example.manageruniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "transactions")
@Getter
@Data
public class Transaction extends Base {
    @ManyToOne
    @JoinColumn(name = "register_id")
    private Register register;
}
