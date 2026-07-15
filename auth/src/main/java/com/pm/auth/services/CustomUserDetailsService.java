package com.pm.auth.services;

import com.pm.auth.Repository.AuthRepository;
import com.pm.auth.model.Users;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final AuthRepository authRepository;
    CustomUserDetailsService(AuthRepository authRepository){
        this.authRepository=authRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users=authRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("user not found"));
        return User.builder().username(users.getUsername()).password(users.getPassword()).roles("USER").build();
    }
}
