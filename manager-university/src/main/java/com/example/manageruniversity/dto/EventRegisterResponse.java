package com.example.manageruniversity.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class EventRegisterResponse {
    private String name;
    private Date executeAt;
    private String type;
}
