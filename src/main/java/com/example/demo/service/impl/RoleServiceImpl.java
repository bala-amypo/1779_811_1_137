package com.example.demo.service.impl;

import com.example.demo.entity.Role;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repo;

    public RoleServiceImpl(RoleRepository repo) {
        this.repo = repo;
    }

    @Override
    public Role create(Role role) 
        if (repo.existsByRoleName(role.getRoleName())) {
            throw new BadRequestException("Role name already exists");
        }
        return repo.save(role);
    }

    @Override
    public Role get(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Role not found with id " + id));
    }

    @Override
    public List<Role> all() {
        return repo.findAll();
    }

    @Override
    public Role update(Long id, Role role) {
        Role db = get(id);
        db.setRoleName(role.getRoleName());
        db.setDescription(role.getDescription());
        return repo.save(db);
    }

    @Override
    public void deactivate(Long id) {
        Role db = get(id);
        db.setActive(false);
        repo.save(db);
    }
}
