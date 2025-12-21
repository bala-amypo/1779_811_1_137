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

    @PostMapping
    public RolePermission grantPermission(@RequestBody RolePermission rolePermission) {
        return service.grant(rolePermission);
    }

    @GetMapping("/role/{roleId}")
    public List<RolePermission> getPermissionsByRole(@PathVariable Long roleId) {
        return service.getByRoleId(roleId);
    }

    @GetMapping("/{id}")
    public RolePermission getMapping(@PathVariable Long id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void revokePermission(@PathVariable Long id) {
        service.revoke(id);
    }
}
