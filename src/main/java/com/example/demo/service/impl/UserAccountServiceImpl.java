package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserAccountEntity;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repo;

    public UserAccountServiceImpl(UserAccountRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserAccountEntity create(UserAccountEntity user) {
        return repo.save(user);
    }

    @Override
    public UserAccountEntity update(Long id, UserAccountEntity user) {
        UserAccountEntity existing = getById(id);
        existing.setFullName(user.getFullName());
        existing.setEmail(user.getEmail());
        return repo.save(existing);
    }

    @Override
    public UserAccountEntity getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public List<UserAccountEntity> getAllActive() {
        return repo.findByActiveTrue();
    }

    @Override
    public void deactivate(Long id) {
        UserAccountEntity user = getById(id);
        user.setActive(false);
        repo.save(user);
    }
}
