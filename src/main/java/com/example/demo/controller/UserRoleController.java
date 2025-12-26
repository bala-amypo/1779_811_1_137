package com.example.demo.controller;

import com.example.demo.entity.UserRole;
import com.example.demo.service.UserRoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-roles")
public class UserRoleController {

    private final UserRoleService service;

    public UserRoleController(UserRoleService service) {
        this.service = service;
    }

    @PostMapping
    public UserRole assign(@RequestBody UserRole ur) {
        return service.assignRole(ur);
    }

    @GetMapping("/user/{id}")
    public List<UserRole> getRoles(@PathVariable Long id) {
        return service.getRolesForUser(id);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        service.removeRole(id);
    }
}
