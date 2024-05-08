package com.example.manageruniversity.repository.event;

import com.example.manageruniversity.dto.EventRegisterResponse;
import com.example.manageruniversity.entity.EventRegister;

import java.sql.SQLException;
import java.util.List;

public interface Event {

    void event(EventRegister eventRegister) throws SQLException;
    List<EventRegisterResponse> findAllEvent() throws SQLException;
}
