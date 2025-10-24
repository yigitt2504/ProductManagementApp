package com.spring.service;

import com.spring.model.User;
import com.spring.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User appUser = userRepository.findByUsername(username);
        if (appUser == null) throw new UsernameNotFoundException("User not found: " + username);

        return org.springframework.security.core.userdetails.User
                .withUsername(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(appUser.getRole() == null ? "USER" : appUser.getRole())
                .build();
    }
}
