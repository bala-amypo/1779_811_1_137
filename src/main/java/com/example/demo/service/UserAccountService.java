package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;

public interface UserAccountService {

    UserAccount create(UserAccount user);

    UserAccount get(Long id);

    List<UserAccount> all();

    UserAccount update(Long id, UserAccount user);

    void deactivate(Long id);
}
