package com.example.petmatchlab.security;

import java.util.Locale;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.petmatchlab.model.AppUser;
import com.example.petmatchlab.repository.AppUserRepository;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

    private final AppUserRepository userRepository;

    public DatabaseUserDetailsService(AppUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        String email = username.strip().toLowerCase(Locale.ROOT);

        AppUser user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException(
                "User not found"
            ));

        return User.builder()
            .username(user.getEmail())
            .password(user.getPasswordHash())
            .authorities("ROLE_" + user.getRole().name())
            .disabled(!user.isEnabled())
            .build();
    }
}
