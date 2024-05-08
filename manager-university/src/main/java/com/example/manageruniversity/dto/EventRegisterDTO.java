package com.example.manageruniversity.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EventRegisterDTO extends BaseDTO {
    private String nameEvent;
    private LocalDateTime start;
    private int intervalDay;
    private SeasonDTO seasonDTO;
    private List<MajorDTO> majorDTOS = new ArrayList<>();
    private boolean expired;
}
