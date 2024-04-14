package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.RoomClassDTO;
import com.example.manageruniversity.entity.RoomClass;
import com.example.manageruniversity.mapper.RoomClassMapper;
import com.example.manageruniversity.repository.RoomClassRepository;
import com.example.manageruniversity.service.IRoomClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomClassServiceImpl implements IRoomClassService {

    private final RoomClassRepository roomClassRepository;

    @Autowired
    public RoomClassServiceImpl(RoomClassRepository roomClassRepository) {
        this.roomClassRepository = roomClassRepository;
    }

    @Override
    public RoomClassDTO saveOrUpdate(RoomClassDTO roomClassDTO) {
        RoomClass roomClass = null;
        if(roomClassDTO.getId() != null) {
        } else {
            roomClass = RoomClassMapper.mapper.roomClassDTOToEntity(roomClassDTO);
        }
        roomClass = roomClassRepository.save(roomClass);
        return RoomClassMapper.mapper.roomClassToDTO(roomClass);
    }

    @Override
    public List<RoomClassDTO> records() {
        List<RoomClass> roomClasses = roomClassRepository.findAll();
        return roomClasses.stream().map(roomClass -> {
            return RoomClassMapper.mapper.roomClassToDTO(roomClass);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        roomClassRepository.deleteById(id);
    }
}
