package com.fullstack.BackenExT.service;

import com.fullstack.BackenExT.model.CustomUserDetails;
import com.fullstack.BackenExT.model.User;
import com.fullstack.BackenExT.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(()->
                new RuntimeException("User does not exist with username "+ username));

        return new CustomUserDetails(user);
    }
}
