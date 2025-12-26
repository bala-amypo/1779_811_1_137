package com.example.demo.controller;

import com.example.demo.entity.Permission;
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

    // ✅ MUST return List<Permission>
    @GetMapping("/role/{roleId}")
    public List<Permission> getPermissionsForRole(@PathVariable Long roleId) {
        return service.getPermissionsForRole(roleId);
    }

    @GetMapping("/{id}")
    public RolePermission getMappingById(@PathVariable Long id) {
        return service.getMappingById(id);
    }
}
