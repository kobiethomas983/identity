package com.app.identity.repository;

import com.app.identity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    void deleteRoleByRoleId(String roleId);
    Role findRoleByRoleId(String roleId);
}
