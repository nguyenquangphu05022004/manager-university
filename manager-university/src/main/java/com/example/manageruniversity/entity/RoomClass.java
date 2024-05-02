package com.example.manageruniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room_class")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomClass extends Base{
    private String name;
    @OneToMany(mappedBy = "roomClass")
    private List<Time> times = new ArrayList<>();

}
