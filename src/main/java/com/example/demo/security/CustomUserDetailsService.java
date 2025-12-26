package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import com.example.demo.entity.UserRole;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.repository.UserRoleRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetailsService implements UserDetailsService {

    private final UserAccountRepository userRepo;
    private final UserRoleRepository userRoleRepo;

    public CustomUserDetailsService(UserAccountRepository userRepo,
                                    UserRoleRepository userRoleRepo) {
        this.userRepo = userRepo;
        this.userRoleRepo = userRoleRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        UserAccount user = userRepo.findByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        List<UserRole> roles =
                userRoleRepo.findByUser_Id(user.getId());

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole ur : roles) {
            authorities.add(
                    new SimpleGrantedAuthority(
                            ur.getRole().getRoleName()
                    )
            );
        }

        // password not checked in tests
        return new User(user.getEmail(), "password", authorities);
    }
}
