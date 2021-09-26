package com.app.identity.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RolePermissionRepository {
    private final static Logger LOGGER = LoggerFactory.getLogger(RolePermissionRepository.class);

    private static final String ROLE_PERMISSION_TABLE = "ps_role_permission";
    private static final String getPermissionsByRoleId = String.format("SELECT permission_id FROM %s WHERE role_id = ?", ROLE_PERMISSION_TABLE);
    private static final String getRolesByPermissionId = String.format("SELECT role_id FROM %s WHERE permission_id = ?", ROLE_PERMISSION_TABLE);
    private static final String deleteRolePermission = String.format("DELETE FROM %s WHERE role_id = ? AND permission_id = ?", ROLE_PERMISSION_TABLE);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RolePermissionRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getPermissionsByRoleId(String roleId) {
        return jdbcTemplate.queryForList(getPermissionsByRoleId, String.class, roleId);
    }

}
