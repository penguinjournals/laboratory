package com.penguinjournals.laboratory.security.service;

import com.penguinjournals.laboratory.domain.User;
import com.penguinjournals.laboratory.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        User user = getUserRepository()
                .findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userName));

        return UserDetailsImpl.build(user);
    }

    private UserRepository getUserRepository() {
        return this.userRepository;
    }
}
