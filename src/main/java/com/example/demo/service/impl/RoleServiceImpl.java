package com.example.demo.service.impl;

import com.example.demo.entity.Role;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repo;

    public RoleServiceImpl(RoleRepository repo) {
        this.repo = repo;
    }

    @Override
    public Role createRole(Role role) {
        if (repo.findByRoleName(role.getRoleName()).isPresent()) {
            throw new BadRequestException("Duplicate role");
        }
        role.setActive(true);
        return repo.save(role);
    }

    @Override
    public Role updateRole(Long id, Role updated) {
        Role role = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));

        role.setRoleName(updated.getRoleName());
        role.setDescription(updated.getDescription());
        return repo.save(role);
    }

    @Override
    public void deactivateRole(Long id) {
        Role role = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));
        role.setActive(false);
        repo.save(role);
    }
}
