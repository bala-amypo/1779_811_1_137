package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String fullName;
    private boolean active;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // ===== GETTERS & SETTERS (REQUIRED) =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {                 // 🔥 FIX
        return email;
    }

    public void setEmail(String email) {       // 🔥 FIX
        this.email = email;
    }

    public String getPassword() {              // 🔥 FIX
        return password;
    }

    public void setPassword(String password) { // 🔥 FIX
        this.password = password;
    }

    public String getFullName() {               // 🔥 FIX
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isActive() {                 // 🔥 FIX
        return active;
    }

    public void setActive(boolean active) {     // 🔥 FIX
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    // ===== JPA LIFECYCLE =====

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.active = true;
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
