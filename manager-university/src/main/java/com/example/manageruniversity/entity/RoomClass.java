package com.example.manageruniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room_class")
@Data
@Getter
@ToString
public class RoomClass extends Base{


    private String name;

    @OneToMany(mappedBy = "roomClass")
    private List<Time> times = new ArrayList<>();

}
