package com.example.manageruniversity.service.impl;

import com.example.manageruniversity.dto.TestScheduleDTO;
import com.example.manageruniversity.repository.TestScheduleRepository;
import com.example.manageruniversity.service.ITestScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TestScheduleServiceImpl implements ITestScheduleService {
    private final TestScheduleRepository testScheduleRepository;
    @Override
    public TestScheduleDTO saveOrUpdate(TestScheduleDTO testScheduleDTO) {

        return null;
    }

    @Override
    public List<TestScheduleDTO> records() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
