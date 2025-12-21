package com.example.demo.service;

import com.example.demo.entity.UserRole;
import java.util.List;

public interface UserRoleService {
    UserRole assign(UserRole userRole);
    UserRole get(Long id);
    List<UserRole> getByUserId(Long userId);
    void remove(Long id);
}
