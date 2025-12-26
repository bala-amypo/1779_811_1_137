package com.example.demo.service.impl;

import com.example.demo.entity.RolePermission;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RolePermissionRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.PermissionRepository;
import com.example.demo.service.RolePermissionService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionRepository repo;

    public RolePermissionServiceImpl(
            RolePermissionRepository repo,
            RoleRepository roleRepository,
            PermissionRepository permissionRepository) {
        this.repo = repo;
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
