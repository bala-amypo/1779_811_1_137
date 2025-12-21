package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RoleEntity;
import com.example.demo.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @PostMapping
    public RoleEntity create(@RequestBody RoleEntity role) {
        return service.create(role);
    }

    @PutMapping("/{id}")
    public RoleEntity update(@PathVariable Long id,
                             @RequestBody RoleEntity role) {
        return service.update(id, role);
    }

    @GetMapping("/{id}")
    public RoleEntity getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // ✅ Only ACTIVE roles
    @GetMapping
    public List<RoleEntity> getAllActive() {
        return service.getAllActive();
    }

    // ✅ DEACTIVATE (NOT DELETE)
    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivate(id);
    }
}
