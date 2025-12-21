package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RoleEntity;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repo;

    public RoleServiceImpl(RoleRepository repo) {
        this.repo = repo;
    }

    @Override
    public RoleEntity create(RoleEntity role) {
        return repo.save(role);
    }

    @Override
    public RoleEntity update(Long id, RoleEntity role) {
        RoleEntity existing = getById(id);
        existing.setRoleName(role.getRoleName());
        return repo.save(existing);
    }

    @Override
    public RoleEntity getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public List<RoleEntity> getAllActive() {
        return repo.findByActiveTrue();
    }

    // ✅ SOFT DELETE
    @Override
    public void deactivate(Long id) {
        RoleEntity role = getById(id);
        role.setActive(false);
        repo.save(role);
    }
}
