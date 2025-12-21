package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountServiceImpl(UserAccountRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public UserAccount create(UserAccount user) {
        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        // NO password encoding
        return repository.save(user);
    }

    @Override
    public UserAccount get(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<UserAccount> all() {
        return repository.findAll();
    }

    @Override
    public UserAccount update(Long id, UserAccount user) {
        UserAccount db = get(id);
        db.setFullName(user.getFullName());
        return repository.save(db);
    }

    @Override
    public void deactivate(Long id) {
        UserAccount db = get(id);
        db.setActive(false);
        repository.save(db);
    }
}
