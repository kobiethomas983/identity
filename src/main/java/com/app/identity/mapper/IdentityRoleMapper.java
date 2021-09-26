package com.app.identity.mapper;

import com.app.identity.model.IdentityRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class IdentityRoleMapper implements RowMapper<IdentityRole> {
    @Override
    public IdentityRole mapRow(ResultSet resultSet, int i) throws SQLException {
        String identityId = resultSet.getString("identity_id");
        String roleId = resultSet.getString("role_id");
        Timestamp createdAt = resultSet.getTimestamp("created_at");

        return new IdentityRole(identityId, roleId, createdAt);
    }
}
