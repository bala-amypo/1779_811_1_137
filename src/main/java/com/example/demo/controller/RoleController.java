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

    @GetMapping
    public List<RoleEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public RoleEntity getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public RoleEntity update(@PathVariable Long id,
                             @RequestBody RoleEntity role) {
        return service.update(id, role);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
