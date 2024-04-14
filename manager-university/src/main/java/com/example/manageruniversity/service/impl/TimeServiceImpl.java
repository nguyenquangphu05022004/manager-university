package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.TimeDTO;
import com.example.manageruniversity.entity.Time;
import com.example.manageruniversity.mapper.TimeMapper;
import com.example.manageruniversity.repository.TimeRepository;
import com.example.manageruniversity.service.ITimeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeServiceImpl implements ITimeService {

    private final TimeRepository timeRepository;

    public TimeServiceImpl(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @Override
    public TimeDTO saveOrUpdate(TimeDTO timeDTO) {
        Time time = null;
        if(timeDTO.getId() != null) {

        } else {
            time = TimeMapper.mapper.timeDTOToEntity(timeDTO);
        }
        time = timeRepository.save(time);
        return TimeMapper.mapper.timeToDTO(time);
    }

    @Override
    public List<TimeDTO> records() {
        List<Time> times = timeRepository.findAll();
        return times.stream().map(time ->  {
            return TimeMapper.mapper.timeToDTO(time);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        timeRepository.deleteById(id);
    }
}
