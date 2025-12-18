package com.example.demo.controller;

import com.example.demo.entity.UserRoleEntity;
import com.example.demo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class UserRoleController {

    @Autowired
    private UserRoleService roleService;

    @PostMapping
    public UserRoleEntity createRole(@RequestBody UserRoleEntity role) {
        return roleService.createRole(role);
    }

    @PutMapping("/{id}")
    public UserRoleEntity updateRole(@PathVariable Long id,@RequestBody UserRoleEntity role) {
        return roleService.updateRole(id, role);
    }

    @GetMapping("/{id}")
    public UserRoleEntity getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @GetMapping
    public List<UserRoleEntity> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/{id}/deactivate")
    public UserRoleEntity deactivateRole(@PathVariable Long id) {
        return roleService.deactivateRole(id);
    }
}
