package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String roleName;

    private String description;
    private Boolean active = true;

    public Role() {}

    public Role(String roleName, String description) {
        this.roleName = roleName;
        this.description = description;
        this.active = true;
    }

    // getters & setters
    public Long getId() { return id; }
    public String getRoleName() { return roleName; }
    public String getDescription() { return description; }
    public Boolean getActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setRoleName(String roleName) { this.roleName = roleName; }
    public void setDescription(String description) { this.description = description; }
    public void setActive(Boolean active) { this.active = active; }
}
