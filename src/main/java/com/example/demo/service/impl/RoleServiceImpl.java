package com.example.demo.service.impl;

import com.example.demo.entity.Role;
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

    public Role create(Role role) {
        return repo.save(role);
    }

    public Role get(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Role> all() {
        return repo.findAll();
    }

    public Role update(Long id, Role role) {
        Role db = get(id);
        db.setDescription(role.getDescription());
        return repo.save(db);
    }

    public void deactivate(Long id) {
        Role db = get(id);
        db.setActive(false);
        repo.save(db);
    }
}
