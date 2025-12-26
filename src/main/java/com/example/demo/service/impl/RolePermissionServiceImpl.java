package com.example.demo.service.impl;

import com.example.demo.entity.RolePermission;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.RolePermissionService;

import java.util.List;

public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionRepository repo;
    private final RoleRepository roleRepo;
    private final PermissionRepository permRepo;

    public RolePermissionServiceImpl(RolePermissionRepository repo,
                                     RoleRepository roleRepo,
                                     PermissionRepository permRepo) {
        this.repo = repo;
        this.roleRepo = roleRepo;
        this.permRepo = permRepo;
    }

    @Override
    public List<RolePermission> getPermissionsForRole(Long roleId) {
        return repo.findByRole_Id(roleId);
    }

    @Override
    public RolePermission getMappingById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mapping not found"));
    }
}
