package com.example.demo.repository;

import com.example.demo.entity.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRoleRepository {

    Optional<UserRole> findById(Long id);

    List<UserRole> findByUser_Id(Long userId);

    boolean existsById(Long id);

    UserRole save(UserRole userRole);

    void deleteById(Long id);
}
