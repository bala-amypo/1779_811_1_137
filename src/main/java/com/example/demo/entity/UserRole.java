package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserAccount user;

    @ManyToOne
    private Role role;

    private Instant assignedAt;

    @PrePersist
    void onAssign() {
        assignedAt = Instant.now();
    }

    public Long getId() { return id; }
    public UserAccount getUser() { return user; }
    public Role getRole() { return role; }

    public void setUser(UserAccount user) { this.user = user; }
    public void setRole(Role role) { this.role = role; }
}
