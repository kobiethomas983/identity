package com.app.identity.service;

import com.app.identity.model.IdentityRole;
import com.app.identity.repository.IdentityRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityRoleService {
    private final IdentityRoleRepository identityRoleRepository;

    @Autowired
    public IdentityRoleService(IdentityRoleRepository identityRoleRepository) {
        this.identityRoleRepository = identityRoleRepository;
    }

    public IdentityRole findIdentityRole(String identityId, String roleId) {
        return identityRoleRepository.getIdentityRole(identityId, roleId);
    }

    public IdentityRole addIdentityRole(IdentityRole identityRole) {
        return identityRoleRepository.saveIdentityRole(identityRole);
    }

    public void deleteIdentityRole(String identityId, String roleId) {
        identityRoleRepository.removeIdentityFromRole(identityId, roleId);
    }
}
