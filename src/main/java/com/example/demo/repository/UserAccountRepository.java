package com.example.demo.repository;

import com.example.demo.entity.UserAccount;

import java.util.List;
import java.util.Optional;

public interface UserAccountRepository {

    Optional<UserAccount> findById(Long id);

    Optional<UserAccount> findByEmail(String email);

    boolean existsByEmail(String email);

    List<UserAccount> findAll();

    UserAccount save(UserAccount user);
}
