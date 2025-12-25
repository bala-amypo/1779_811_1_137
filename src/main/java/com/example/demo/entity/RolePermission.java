package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "role_permissions")
public class RolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Permission permission;

    private Instant grantedAt;

    @PrePersist
    void onGrant() {
        grantedAt = Instant.now();
    }

    public Long getId() { return id; }
    public Role getRole() { return role; }
    public Permission getPermission() { return permission; }

    public void setRole(Role role) { this.role = role; }
    public void setPermission(Permission permission) { this.permission = permission; }
}
