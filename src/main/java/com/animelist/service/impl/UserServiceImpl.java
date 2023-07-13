package com.animelist.service.impl;

import com.animelist.model.Role;
import com.animelist.model.User;
import com.animelist.repository.UserRepository;
import com.animelist.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't get User from DB by ID: " + id));
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User update(Long id, User user) {
        User reference = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Can't get User from DB for update by ID: " + id));;
        reference.setLogin(user.getLogin());
        reference.setOrders(user.getOrders());
        reference.setRoles(user.getRoles());
        return reference;
    }

    @Override
    public List<User> findByRole(Role role) {
        return userRepository.findAllByRole(role);
    }
}
