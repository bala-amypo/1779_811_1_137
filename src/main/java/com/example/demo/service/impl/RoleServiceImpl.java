package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.RoleEntity;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repo;

    public RoleServiceImpl(RoleRepository repo) {
        this.repo = repo;
    }

    public RoleEntity create(RoleEntity role) {
        return repo.save(role);
    }

    public List<RoleEntity> getAll() {
        return repo.findAll();
    }

    public RoleEntity getById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public RoleEntity update(Long id, RoleEntity role) {
        RoleEntity r = getById(id);
        r.setRoleName(role.getRoleName());
        r.setActive(role.getActive());
        return repo.save(r);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
