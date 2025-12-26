package com.example.demo.controller;

import com.example.demo.entity.RolePermission;
import com.example.demo.service.RolePermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role-permissions")
public class RolePermissionController {

    private final RolePermissionService service;

    public RolePermissionController(RolePermissionService service) {
        this.service = service;
    }

    // Get all permissions for a role
    @GetMapping("/role/{roleId}")
    public List<RolePermission> getPermissionsForRole(@PathVariable Long roleId) {
        return service.getPermissionsForRole(roleId);
    }

    // Get a specific role-permission mapping
    @GetMapping("/{id}")
    public RolePermission getMapping(@PathVariable Long id) {
        return service.getMappingById(id);
    }
}
