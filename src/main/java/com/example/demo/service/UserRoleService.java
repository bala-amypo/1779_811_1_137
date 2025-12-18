package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.UserRoleEntity;

public interface UserRoleService {

    public UserRoleEntity createRole(UserRoleEntity role);

    public UserRoleEntity updateRole(Long id, UserRoleEntity role);

    public UserRoleEntity getRoleById(Long id);

    public List<UserRoleEntity> getAllRoles();

    public UserRoleEntity deactivateRole(Long id);
}
