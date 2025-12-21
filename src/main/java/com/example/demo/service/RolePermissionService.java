package com.example.demo.service;

import com.example.demo.entity.RolePermission;
import java.util.List;

public interface RolePermissionService {
    RolePermission grant(RolePermission rolePermission);

    RolePermission get(Long id);

    List<RolePermission> getByRoleId(Long roleId);
    
    void revoke(Long id);
}
