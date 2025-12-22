package com.example.demo.service.impl;

import com.example.demo.entity.RolePermission;
import com.example.demo.repository.RolePermissionRepository;
import com.example.demo.service.RolePermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionRepository repo;
    @Override
    public RolePermissionServiceImpl(RolePermissionRepository repo) {
        this.repo = repo;
    }
    @Override
    public RolePermission grant(RolePermission rp) {
        return repo.save(rp);
    }
    @Override
    public RolePermission get(Long id) {
        return repo.findById(id).orElseThrow();
    }
    @Override
    public List<RolePermission> getByRoleId(Long roleId) {
        return repo.findByRole_Id(roleId);
    }
    @Override
    public void revoke(Long id) {
        repo.deleteById(id);
    }
}
