package com.animelist.service;

import com.animelist.model.Role;
import java.util.Optional;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);

    void delete(Long id);
}
