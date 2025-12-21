package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.UserAccountEntity;

public interface UserAccountService {

    UserAccountEntity create(UserAccountEntity user);
    List<UserAccountEntity> getAll();
    UserAccountEntity getById(Long id);
    UserAccountEntity update(Long id, UserAccountEntity user);
    void delete(Long id);
}
