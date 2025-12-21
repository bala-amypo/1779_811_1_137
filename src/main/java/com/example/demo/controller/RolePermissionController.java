package com.example.demo.controller;

import com.example.demo.entity.RolePermission;
import com.example.demo.service.RolePermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role-permissions")
public class RolePermissionController {

    private final RolePermissionService service;

    public RolePermissionController(RolePermissionService service) {
        this.service = service;
    }

    // ✅ POST /api/role-permissions  → Grant permission
    @PostMapping
    public RolePermission grantPermission(@RequestBody RolePermission rolePermission) {
        return service.grant(rolePermission);
    }

    // ✅ GET /api/role-permissions/role/{roleId} → List permissions for role
    @GetMapping("/role/{roleId}")
    public List<RolePermission> getPermissionsByRole(@PathVariable Long roleId) {
        return service.getByRoleId(roleId);
    }

    // ✅ GET /api/role-permissions/{id} → Get mapping
    @GetMapping("/{id}")
    public RolePermission getMapping(@PathVariable Long id) {
        return service.get(id);
    }

    // ✅ DELETE /api/role-permissions/{id} → Revoke permission
    @DeleteMapping("/{id}")
    public void revokePermission(@PathVariable Long id) {
        service.revoke(id);
    }
}
