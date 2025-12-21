package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String permissionKey;

    private String description;
    private Boolean active = true;

    public Permission() {}

    public Permission(String permissionKey, String description) {
        this.permissionKey = permissionKey;
        this.description = description;
        this.active = true;
    }

    // getters & setters
    public Long getId() { return id; }
    public String getPermissionKey() { return permissionKey; }
    public String getDescription() { return description; }
    public Boolean getActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setPermissionKey(String permissionKey) { this.permissionKey = permissionKey; }
    public void setDescription(String description) { this.description = description; }
    public void setActive(Boolean active) { this.active = active; }
}
