package com.example.manageruniversity.entity;

import com.example.manageruniversity.entity.auth.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "avatars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Avatar extends Base{
    private String avatarName;
    private String folderStorage;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
