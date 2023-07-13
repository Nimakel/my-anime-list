package com.animelist.service;

import com.animelist.model.Role;
import com.animelist.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User add(User user);

    User get(Long id);

    Optional<User> findByLogin(String login);

    User update(Long id, User user);

    List<User> findByRole(Role role);
}
