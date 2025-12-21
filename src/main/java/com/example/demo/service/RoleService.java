package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.RoleEntity;

public interface RoleService {

    RoleEntity create(RoleEntity role);
    List<RoleEntity> getAll();
    RoleEntity getById(Long id);
    RoleEntity update(Long id, RoleEntity role);
    void delete(Long id);
}
