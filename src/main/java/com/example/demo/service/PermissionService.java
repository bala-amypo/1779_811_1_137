package com.example.demo.service;

import com.example.demo.entity.Permission;
import java.util.List;

public interface PermissionService {
    Permission create(Permission permission);
    Permission get(Long id);
    List<Permission> all();
    Permission update(Long id, Permission permission);
    void deactivate(Long id);
}
