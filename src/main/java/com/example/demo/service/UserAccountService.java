package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.UserAccountEntity;

public interface UserAccountService {

    UserAccountEntity create(UserAccountEntity user);

    UserAccountEntity update(Long id, UserAccountEntity user);

    UserAccountEntity getById(Long id);

    List<UserAccountEntity> getAllActive();

    void deactivate(Long id);
}
