package com.example.demo.service.impl;

import com.example.demo.entity.Permission;
import com.example.demo.repository.PermissionRepository;
import com.example.demo.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repo;

    public PermissionServiceImpl(PermissionRepository repo) {
        this.repo = repo;
    }

    public Permission create(Permission permission) {
        return repo.save(permission);
    }

    public Permission get(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Permission> all() {
        return repo.findAll();
    }

    public Permission update(Long id, Permission permission) {
        Permission db = get(id);
        db.setDescription(permission.getDescription());
        return repo.save(db);
    }

    public void deactivate(Long id) {
        Permission db = get(id);
        db.setActive(false);
        repo.save(db);
    }
}
