package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.UserAccountEntity;

public interface UserAccountRepository
        extends JpaRepository<UserAccountEntity, Long> {
}
