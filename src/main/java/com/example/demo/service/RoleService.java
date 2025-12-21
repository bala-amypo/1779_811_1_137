package com.example.demo.service;

import com.example.demo.entity.Role;
import java.util.List;

public interface RoleService {
    Role create(Role role);
    Role get(Long id);
    List<Role> all();
    Role update(Long id, Role role);
    void deactivate(Long id);
}
