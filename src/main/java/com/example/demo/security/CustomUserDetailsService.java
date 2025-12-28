package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserAccountRepository userRepo;

    // ✅ DO NOT CHANGE THIS CONSTRUCTOR (tests depend on it)
    public CustomUserDetailsService(UserAccountRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        UserAccount user = userRepo.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found: " + email));

        // ✅ IMPORTANT: password MUST be non-null & encoded
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new UsernameNotFoundException("User password not set");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.isActive(),     // enabled
                true,                // accountNonExpired
                true,                // credentialsNonExpired
                true,                // accountNonLocked
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
