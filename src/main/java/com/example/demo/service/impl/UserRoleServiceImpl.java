package com.example.demo.service.impl;

import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserRoleRepository;
import com.example.demo.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository repo;

    public UserRoleServiceImpl(UserRoleRepository repo) {
        this.repo = repo;
    }
    @Override
    public UserRole assign(UserRole ur) {
        return repo.save(ur);
    }
    @Override
    public UserRole get(Long id) {
        return repo.findById(id).orElseThrow();
    }
    @Override
    public List<UserRole> getByUserId(Long userId) {
        return repo.findByUser_Id(userId);
    }
    @Override
    public void remove(Long id) {
        repo.deleteById(id);
    }
}
