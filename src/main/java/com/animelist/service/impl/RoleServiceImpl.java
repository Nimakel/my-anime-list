package com.animelist.service.impl;

import com.animelist.model.Role;
import com.animelist.repository.RoleRepository;
import com.animelist.service.RoleService;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role add(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getByName(String roleName) {
        return roleRepository.getRoleByName(roleName);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
