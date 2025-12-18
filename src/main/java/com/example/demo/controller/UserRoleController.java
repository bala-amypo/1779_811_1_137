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

    @GetMapping
    public List<UserRoleEntity> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public UserRoleEntity getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    @PutMapping("/{id}")
    public UserRoleEntity updateRole(
            @PathVariable Long id,
            @RequestBody UserRoleEntity role) {
        return roleService.updateRole(id, role);
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return "Role deleted successfully";
    }
}
