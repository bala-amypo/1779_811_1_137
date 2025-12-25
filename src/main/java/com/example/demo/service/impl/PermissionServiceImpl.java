package com.example.demo.service.impl;

import com.example.demo.entity.Permission;
import com.example.demo.exception.ResourceNotFoundException;
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

    @Override
    public Permission createPermission(Permission permission) {
        return repo.save(permission);
    }

    @Override
    public Permission getPermissionById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found"));
    }

    @Override
    public List<Permission> getAllPermissions() {
        return repo.findAll();
    }

    @Override
    public void deactivatePermission(Long id) {
        Permission p = getPermissionById(id);
        p.setActive(false);
        repo.save(p);
    }
}
