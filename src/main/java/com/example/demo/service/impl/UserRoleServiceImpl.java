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

    public UserRole assign(UserRole ur) {
        return repo.save(ur);
    }

    public UserRole get(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<UserRole> getByUserId(Long userId) {
        return repo.findByUser_Id(userId);
    }

    public void remove(Long id) {
        repo.deleteById(id);
    }
}
