package com.example.demo.controller;

import com.example.demo.entity.Permission;
import com.example.demo.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    private final PermissionService service;

    public PermissionController(PermissionService service) {
        this.service = service;
    }

    @PostMapping
    public Permission create(@RequestBody Permission permission) {
        return service.create(permission);
    }

    @GetMapping("/{id}")
    public Permission get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<Permission> all() {
        return service.all();
    }

    @PutMapping("/{id}")
    public Permission update(@PathVariable Long id, @RequestBody Permission permission) {
        return service.update(id, permission);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivate(id);
    }
}
