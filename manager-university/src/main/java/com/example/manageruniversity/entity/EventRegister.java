package com.example.manageruniversity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "event_registers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventRegister extends Base{
    private String eventName;
    private LocalDateTime start;
    private int intervalDay;
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
    @ManyToMany
    @JoinTable(name = "event_registers_major", joinColumns = @JoinColumn(name = "event_registers_id"),
    inverseJoinColumns = @JoinColumn(name = "major_id"))
    private List<Major> majors =new ArrayList<>();
    private boolean expired;
}
