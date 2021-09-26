package com.app.identity.service;

import com.app.identity.repository.RolePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionService {
    private final RolePermissionRepository rolePermissionRepository;

    @Autowired
    public RolePermissionService(RolePermissionRepository rolePermissionRepository) {
        this.rolePermissionRepository = rolePermissionRepository;
    }

    public List<String> getPermissionsByRoleId(String roleId) {
        return rolePermissionRepository.getPermissionsByRoleId(roleId);
    }
}
