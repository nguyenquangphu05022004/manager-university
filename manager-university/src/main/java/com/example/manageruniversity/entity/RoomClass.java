package com.example.manageruniversity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room_class")
public class RoomClass extends Base{
    private String name;
    private List<Time> times = new ArrayList<>();

}
