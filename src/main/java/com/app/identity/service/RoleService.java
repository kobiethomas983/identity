package com.app.identity.service;

import com.app.identity.model.Role;
import com.app.identity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role save(Role role) {
        return roleRepository.save(role);
    }

    public void deleteRole(String roleId) {
        roleRepository.deleteRoleByRoleId(roleId);
    }

    public Role findRole(String roleId) {
        return roleRepository.findRoleByRoleId(roleId);
    }

    public List<Role> findRoles() {
        return roleRepository.findAll();
    }
}
