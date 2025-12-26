package com.example.demo.service.impl;

import com.example.demo.entity.Permission;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PermissionRepository;
import com.example.demo.service.PermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository repo;

    public PermissionServiceImpl(PermissionRepository repo) {
        this.repo = repo;
    }

    @Override
    public Permission createPermission(Permission p) {
        if (repo.findByPermissionKey(p.getPermissionKey()).isPresent()) {
            throw new BadRequestException("Duplicate permission");
        }
        p.setActive(true);
        return repo.save(p);
    }

    @Override
    public void deactivatePermission(Long id) {
        Permission p = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found"));
        p.setActive(false);
        repo.save(p);
    }
}
