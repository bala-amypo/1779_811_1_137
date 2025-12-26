package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts")
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // ===== REQUIRED BY TESTS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // 🔥 FIX
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) { // 🔥 FIX
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) { // 🔥 FIX
        this.updatedAt = updatedAt;
    }

    // ===== JPA LIFECYCLE METHODS (TEST EXPECTS THESE) =====

    @PrePersist
    public void prePersist() { // 🔥 FIX
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() { // 🔥 FIX
        this.updatedAt = LocalDateTime.now();
    }
}
