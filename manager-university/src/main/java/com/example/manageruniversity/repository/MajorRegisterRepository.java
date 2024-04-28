package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.MajorRegister;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorRegisterRepository extends JpaRepository<MajorRegister, Long> {
    MajorRegister findByMajorIdAndSeasonDisabled(Long majorId, Boolean disabled);

}
