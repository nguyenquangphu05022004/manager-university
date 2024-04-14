package com.example.manageruniversity.mapper;

import com.example.manageruniversity.dto.RoomClassDTO;
import com.example.manageruniversity.dto.TimeDTO;
import com.example.manageruniversity.entity.RoomClass;
import com.example.manageruniversity.entity.Time;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoomClassMapperTest {

    @Test
    void roomClassDTOToEntity() {



    }

    @Test
    void roomClassToDTO() {
        RoomClass roomClass = new RoomClass();
        roomClass.setName("test");
        Time time = new Time();
        time.setRoomClass(roomClass);
        time.setId(1l);
        roomClass.setTimes(Arrays.asList(time));

        RoomClassDTO classDTO = RoomClassMapper.mapper.roomClassToDTO(roomClass);
        assertThat(classDTO.getTimeDTOS().size()).isEqualTo(1);
        assertThat(classDTO.getTimeDTOS().get(0).getId()).isEqualTo(time.getId());

    }
}