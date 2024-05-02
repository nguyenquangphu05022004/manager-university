package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.PostNotification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  PostNotificationRepository extends JpaRepository<PostNotification, Long> {
    List<PostNotification> findAllByOrderByIdDesc();
}
