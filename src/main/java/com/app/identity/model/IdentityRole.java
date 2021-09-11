package com.app.identity.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Table(name = "ps_identity_role")
public class IdentityRole {

    @Column(name = "identity_id")
    private String identityId;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    public IdentityRole(String identityId,String roleId, Timestamp createdAt) {
        this.identityId = identityId;
        this.roleId = roleId;
        this.createdAt = createdAt;
    }
}
