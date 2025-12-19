package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RoleEntity;
import com.example.demo.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // POST /api/roles
    @PostMapping
    public RoleEntity createRole(@RequestBody RoleEntity role) {
        return roleService.createRole(role);
    }

    // PUT /api/roles/{id}
    @PutMapping("/{id}")
    public RoleEntity updateRole(@PathVariable Long id, @RequestBody RoleEntity role) {
        return roleService.updateRole(id, role);
    }

    // GET /api/roles/{id}
    @GetMapping("/{id}")
    public RoleEntity getRole(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    // GET /api/roles
    @GetMapping
    public List<RoleEntity> getAllRoles() {
        return roleService.getAllRoles();
    }

    // PUT /api/roles/{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public void deactivateRole(@PathVariable Long id) {
        roleService.deactivateRole(id);
    }
}
