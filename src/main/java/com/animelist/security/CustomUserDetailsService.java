package com.animelist.security;

import static org.springframework.security.core.userdetails.User.withUsername;

import com.animelist.model.User;
import com.animelist.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByLogin(username).orElseThrow(() ->
                new RuntimeException("Can't find user by login: " + username));
        org.springframework.security.core.userdetails.User.UserBuilder builder
                = withUsername(username);
        builder.password(user.getPassword());
        builder.authorities(user.getRoles().stream()
                .map(r -> r.getRoleName().name()).toArray(String[]::new));
        return builder.build();
    }
}
