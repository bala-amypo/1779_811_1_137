package com.example.demo.repository;

import com.example.demo.entity.RolePermission;

import java.util.List;
import java.util.Optional;

public interface RolePermissionRepository {

    Optional<RolePermission> findById(Long id);

    List<RolePermission> findByRole_Id(Long roleId);

    RolePermission save(RolePermission rolePermission);
}
