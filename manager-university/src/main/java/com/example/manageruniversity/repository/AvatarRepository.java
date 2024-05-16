package com.example.manageruniversity.repository;

import com.example.manageruniversity.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    @Query("delete from Avatar a where a.user.id = :userId")
    @Modifying
    void deleteByUserId(@Param("userId") Long userId);
}
