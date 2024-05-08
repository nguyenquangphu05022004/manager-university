package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.EventRegisterDTO;
import com.example.manageruniversity.entity.EventRegister;
import com.example.manageruniversity.mapper.EventRegisterMapper;
import com.example.manageruniversity.repository.EventRegisterRepository;
import com.example.manageruniversity.repository.event.Event;
import com.example.manageruniversity.service.IEventRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventRegisterServiceImpl implements IEventRegisterService {

    private final Event event;
    private final EventRegisterRepository eventRegisterRepository;

    @Override
    @Transactional
    public EventRegisterDTO saveOrUpdate(EventRegisterDTO eventRegisterDTO) {
        try {
            EventRegister eventRegister = EventRegisterMapper.mapper.toEntity(eventRegisterDTO);
            EventRegister eventSaved = eventRegisterRepository.save(eventRegister);
            event.event(eventSaved);
            return eventRegisterDTO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<EventRegisterDTO> records() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
