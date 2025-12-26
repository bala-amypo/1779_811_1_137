package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Permission;
import com.example.demo.entity.RolePermission;

public interface RolePermissionService {

    List<Permission> getPermissionsForRole(Long roleId);

    RolePermission getMappingById(Long id);
}
