package com.app.identity.service;

import com.app.identity.model.IdentityRole;
import com.app.identity.model.IdentityRolePK;
import com.app.identity.repository.IdentityRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class IdentityRoleService {
    private final IdentityRoleRepository identityRoleRepository;

    @Autowired
    public IdentityRoleService(IdentityRoleRepository identityRoleRepository) {
        this.identityRoleRepository = identityRoleRepository;
    }

    public IdentityRole addRoleToIdentity(String identityId, String roleId) {
        IdentityRole identityRole = new IdentityRole(
                new IdentityRolePK(identityId, roleId),
                new Timestamp(System.currentTimeMillis())
        );
        System.out.println("Before saving");
        return identityRoleRepository.save(identityRole);
    }
}
