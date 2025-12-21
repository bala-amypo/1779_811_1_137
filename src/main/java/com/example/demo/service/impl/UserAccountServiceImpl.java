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

    public UserAccountEntity create(UserAccountEntity user) {
        return repo.save(user);
    }

    public List<UserAccountEntity> getAll() {
        return repo.findAll();
    }

    public UserAccountEntity getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public UserAccountEntity update(Long id, UserAccountEntity user) {
        UserAccountEntity u = getById(id);
        u.setFullName(user.getFullName());
        u.setEmail(user.getEmail());
        u.setActive(user.getActive());
        return repo.save(u);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
