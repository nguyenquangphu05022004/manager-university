package com.example.manageruniversity.repository.auth;

import com.example.manageruniversity.entity.auth.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query("select t from Token t inner join User u on t.user.id = u.id " +
            "where t.token = :token and t.expired = false and t.revoked=false")
    Optional<Token> findByToken(String token);
}
