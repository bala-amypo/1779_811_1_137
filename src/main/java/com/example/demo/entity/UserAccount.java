package com.example.demo.entity;

import java.time.Instant;

public class UserAccount {

    private Long id;
    private String email;
    private String fullName;
    private boolean active = true; // 🔹 REQUIRED
    private Instant createdAt;
    private Instant updatedAt;

    public void prePersist() {
        createdAt = Instant.now();
        updatedAt = createdAt;
    }

    public void preUpdate() {
        updatedAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // 🔹 REQUIRED BY UserRoleServiceImpl
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
