package com.app.identity.repository;

import com.app.identity.exception.UniqueConstraintException;
import com.app.identity.mapper.IdentityRoleMapper;
import com.app.identity.model.IdentityRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class IdentityRoleRepository {
    private final static Logger LOGGER = LoggerFactory.getLogger(IdentityRoleRepository.class);

    private static final String IDENTITY_ROLE_TABLE = "ps_identity_role";
    private static final String GET_IDENTITY_ROLE = String.format("SELECT * FROM %s WHERE identity_id = ? AND role_id = ?", IDENTITY_ROLE_TABLE);
    private static final String ADD_IDENTITY_ROLE = String.format("INSERT INTO %s(identity_id, role_id, created_at) VALUES(?,?,?)", IDENTITY_ROLE_TABLE);
    private static final String REMOVE_IDENTITY_ROLE = String.format("DELETE FROM %s WHERE identity_id = ? AND role_id = ?", IDENTITY_ROLE_TABLE);


    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<IdentityRole> roleRowMapper;

    @Autowired
    public IdentityRoleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.roleRowMapper = new IdentityRoleMapper();
    }

    public IdentityRole getIdentityRole(String identityId, String roleId) {
        try {
            return jdbcTemplate.queryForObject(GET_IDENTITY_ROLE, roleRowMapper,identityId, roleId);
        } catch (EmptyResultDataAccessException ex) {
            LOGGER.debug("identity " + identityId + " doesn't have role: " + roleId);
            return null;
        }
    }

    public IdentityRole saveIdentityRole(IdentityRole identityRole) {
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        try {
            jdbcTemplate.update(ADD_IDENTITY_ROLE,
                    identityRole.getIdentityId(),
                    identityRole.getRoleId(),
                    createdAt);
        } catch (Exception ex) {
            throw new UniqueConstraintException("Error occurred: " + ex.getCause() + "with identityId: " + identityRole.getIdentityId());
        }
        identityRole.setCreatedAt(createdAt);
        return identityRole;
    }

    public void removeIdentityFromRole(String identityId, String roleId) {
        jdbcTemplate.update(REMOVE_IDENTITY_ROLE, identityId, roleId);
    }

}
