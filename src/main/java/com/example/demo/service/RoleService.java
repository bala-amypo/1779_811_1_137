package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.RoleEntity;

public interface RoleService {

    RoleEntity createRole(RoleEntity role);

    RoleEntity updateRole(Long id, RoleEntity role);

    RoleEntity getRoleById(Long id);

    List<RoleEntity> getAllRoles();

    void deactivateRole(Long id);
}
