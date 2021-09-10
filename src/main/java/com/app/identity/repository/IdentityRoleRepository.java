package com.app.identity.repository;

import com.app.identity.model.IdentityRole;
import com.app.identity.model.IdentityRolePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentityRoleRepository extends JpaRepository<IdentityRole, IdentityRolePK> {

}
