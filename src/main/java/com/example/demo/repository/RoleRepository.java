package com.example.demo.repository;

import com.example.demo.entity.Role;

import java.util.Optional;
@Repository
public interface RoleRepository {

    Optional<Role> findById(Long id);

    Optional<Role> findByRoleName(String roleName);

    Role save(Role role);
}
