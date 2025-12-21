package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private UserAccount user;

    @ManyToOne(optional = false)
    private Role role;

    private Instant assignedAt;

    public UserRole() {}

    public UserRole(UserAccount user, Role role) {
        this.user = user;
        this.role = role;
    }

    @PrePersist
    public void onAssign() {
        assignedAt = Instant.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public UserAccount getUser() { return user; }
    public Role getRole() { return role; }
    public Instant getAssignedAt() { return assignedAt; }

    public void setId(Long id) { this.id = id; }
    public void setUser(UserAccount user) { this.user = user; }
    public void setRole(Role role) { this.role = role; }
}
