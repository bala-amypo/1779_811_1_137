package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @PostMapping
    public Role create(@Valid @RequestBody Role role) {
        return service.createRole(role);
    }

    @GetMapping("/{id}")
    public Role get(@PathVariable Long id) {
        return service.getRoleById(id);
    }

    @GetMapping
    public List<Role> getAll() {
        return service.getAllRoles();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateRole(id);
    }
}
