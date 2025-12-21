package com.example.demo.controller;

import com.example.demo.entity.UserRole;
import com.example.demo.service.UserRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    private final UserRoleService service;

    public UserRoleController(UserRoleService service) {
        this.service = service;
    }

    @PostMapping
    public UserRole assignRole(@RequestBody UserRole userRole) {
        return service.assign(userRole);
    }

    @GetMapping("/user/{userId}")
    public List<UserRole> getRolesForUser(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }

    @GetMapping("/{id}")
    public UserRole getMapping(@PathVariable Long id) {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public void removeRole(@PathVariable Long id) {
        service.remove(id);
    }
}
