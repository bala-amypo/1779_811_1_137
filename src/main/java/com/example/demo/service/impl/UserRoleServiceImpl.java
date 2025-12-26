package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.UserRoleService;

import java.util.List;

public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepo;
    private final UserAccountRepository userRepo;
    private final RoleRepository roleRepo;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepo,
                               UserAccountRepository userRepo,
                               RoleRepository roleRepo) {
        this.userRoleRepo = userRoleRepo;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public UserRole assignRole(UserRole userRole) {
        UserAccount user = userRepo.findById(userRole.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Role role = roleRepo.findById(userRole.getRole().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));

        if (!user.isActive() || !role.isActive()) {
            throw new BadRequestException("Inactive user or role");
        }

        return userRoleRepo.save(userRole);
    }

    @Override
    public List<UserRole> getRolesForUser(Long userId) {
        return userRoleRepo.findByUser_Id(userId);
    }

    @Override
    public UserRole getMappingById(Long id) {
        return userRoleRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mapping not found"));
    }

    @Override
    public void removeRole(Long id) {
        if (!userRoleRepo.existsById(id)) {
            throw new ResourceNotFoundException("Mapping not found");
        }
        userRoleRepo.deleteById(id);
    }
}
