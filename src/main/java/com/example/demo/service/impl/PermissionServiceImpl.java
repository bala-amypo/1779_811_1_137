package com.example.demo.service.impl;

import com.example.demo.entity.Permission;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PermissionRepository;
import com.example.demo.service.PermissionService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repo;

    public PermissionServiceImpl(PermissionRepository repo) {
        this.repo = repo;
    }

    @Override
    public Permission createPermission(Permission permission) {
        if (repo.findByPermissionKey(permission.getPermissionKey()).isPresent()) {
            throw new BadRequestException("Permission already exists");
        }
        return repo.save(permission);
    }

    @Override
    public void deactivatePermission(Long id) {
        Permission p = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found"));
        p.setActive(false);
        repo.save(p);
    }
}
