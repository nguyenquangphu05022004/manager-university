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
    @OneToMany(mappedBy = "tuition", cascade = CascadeType.ALL)
    private List<Subject> subjects  = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "season_Id")
    private Season season;
}
