package com.example.demo.controller;

import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @PostMapping
    public Role create(@RequestBody Role r) {
        return service.createRole(r);
    }

    @PutMapping("/{id}")
    public Role update(@PathVariable Long id, @RequestBody Role r) {
        return service.updateRole(id, r);
    }

    @DeleteMapping("/{id}")
    public void deactivate(@PathVariable Long id) {
        service.deactivateRole(id);
    }
}
