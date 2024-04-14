package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.TimeDTO;
import com.example.manageruniversity.entity.RoomClass;
import com.example.manageruniversity.entity.Time;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TimeMapperTest {

    @Test
    void timeDTOToEntity() {
    }

    @Test
    void timeToDTO() {
        Time time = new Time();
        time.setStartTime(LocalTime.now());

        RoomClass roomClass = new RoomClass();
        roomClass.setName("301-A2");
        roomClass.setTimes(Arrays.asList(time));

        time.setRoomClass(roomClass);

        TimeDTO timeDTO = TimeMapper.mapper.timeToDTO(time);

        System.out.println(timeDTO);

    }

}