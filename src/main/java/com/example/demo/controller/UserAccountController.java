package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    // ✅ CREATE USER (Validation enabled)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserAccount create(@Valid @RequestBody UserAccount user) {
        return service.create(user);
    }

    // ✅ GET USER BY ID
    @GetMapping("/{id}")
    public UserAccount get(@PathVariable Long id) {
        return service.get(id);
    }

    // ✅ GET ALL USERS
    @GetMapping
    public List<UserAccount> all() {
        return service.all();
    }

    // ✅ UPDATE USER (Validation enabled)
    @PutMapping("/{id}")
    public UserAccount update(
            @PathVariable Long id,
            @Valid @RequestBody UserAccount user) {
        return service.update(id, user);
    }

    // ✅ SOFT DELETE / DEACTIVATE USER
    @PutMapping("/{id}/deactivate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivate(@PathVariable Long id) {
        service.deactivate(id);
    }
}
