package com.example.manageruniversity.entity;

import jakarta.persistence.ExcludeSuperclassListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@ExcludeSuperclassListeners
public abstract class Base {
    @Id
    private Long id;
    @CreatedDate
    private LocalDateTime createdDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime modifiedDate;
    @LastModifiedBy
    private String modifiedBy;
}
