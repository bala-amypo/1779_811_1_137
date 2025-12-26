package com.example.demo.repository;

import com.example.demo.entity.Permission;

import java.util.Optional;

public interface PermissionRepository {

    Optional<Permission> findById(Long id);

    Optional<Permission> findByPermissionKey(String permissionKey);

    Permission save(Permission permission);
}
