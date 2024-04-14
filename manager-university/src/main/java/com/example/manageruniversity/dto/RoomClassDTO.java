package com.example.manageruniversity.dto;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Data
@ToString
public class RoomClassDTO extends BaseDTO {
    private String name;
    private List<TimeDTO> timeDTOS = new ArrayList<>();
}
