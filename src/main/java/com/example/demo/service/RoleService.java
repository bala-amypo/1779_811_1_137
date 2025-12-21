package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.RoleEntity;

public interface RoleService {

    RoleEntity create(RoleEntity role);

    RoleEntity update(Long id, RoleEntity role);

    RoleEntity getById(Long id);

    List<RoleEntity> getAllActive();

    void deactivate(Long id);
}
