package com.example.demo.entity;

public class Role {

    private Long id;
    private String roleName;
    private String description;   // 🔹 REQUIRED
    private boolean active = true; // 🔹 REQUIRED

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    // 🔹 REQUIRED BY RoleServiceImpl
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // 🔹 REQUIRED BY UserRoleServiceImpl
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
