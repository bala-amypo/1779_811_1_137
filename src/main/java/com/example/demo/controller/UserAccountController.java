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

    @GetMapping
    public List<UserAccountEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UserAccountEntity getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public UserAccountEntity update(@PathVariable Long id,
                                    @RequestBody UserAccountEntity user) {
        return service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
