package com.example.demo.service;

import com.example.demo.entity.UserRoleEntity;
import com.example.demo.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository roleRepository;

    public UserRoleEntity createRole(UserRoleEntity role) {
        return roleRepository.save(role);
    }

    public List<UserRoleEntity> getAllRoles() {
        return roleRepository.findAll();
    }

    public UserRoleEntity getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }

    public UserRoleEntity updateRole(Long id, UserRoleEntity updatedRole) {
        UserRoleEntity role = getRoleById(id);
        role.setRoleName(updatedRole.getRoleName());
        role.setDescription(updatedRole.getDescription());
        role.setActive(updatedRole.getActive());
        return roleRepository.save(role);
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
