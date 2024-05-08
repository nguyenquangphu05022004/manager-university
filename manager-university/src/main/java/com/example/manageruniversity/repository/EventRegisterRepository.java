package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.EventRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRegisterRepository extends JpaRepository<EventRegister, Long> {
}
