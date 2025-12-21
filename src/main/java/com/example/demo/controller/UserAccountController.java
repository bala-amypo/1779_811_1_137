package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.UserAccountEntity;
import com.example.demo.service.UserAccountService;

@RestController
@RequestMapping("/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping
    public UserAccountEntity create(@RequestBody UserAccountEntity user) {
        return service.create(user);
    }

    @PutMapping("/{id}")
    public UserAccountEntity update(@PathVariable Long id,
                                    @RequestBody UserAccountEntity user) {
        return service.update(id, user);
    }

    @GetMapping("/{id}")
    public UserAccountEntity getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // ✅ Only ACTIVE users
    @GetMapping
    public List<UserAccountEntity> getAllActive() {
        return service.getAllActive();
    }

    // ✅ DEACTIVATE (NOT DELETE)
    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivate(id);
    }
}
