package com.example.demo.controller;

import com.example.demo.entity.Permission;
import com.example.demo.service.PermissionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    private final PermissionService service;

    public PermissionController(PermissionService service) {
        this.service = service;
    }

    @PostMapping
    public Permission create(@RequestBody Permission permission) {
        return service.createPermission(permission);
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        service.deactivatePermission(id);
    }
}
