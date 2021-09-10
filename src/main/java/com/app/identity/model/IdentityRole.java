package com.app.identity.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "ps_identity_role", schema = "public")
public class IdentityRole {
    
    @EmbeddedId
    private IdentityRolePK identityRolePK;

    @Column(name = "created_at")
    private Timestamp createdAt;

    public IdentityRole(IdentityRolePK rolePK, Timestamp createdAt) {
        this.identityRolePK = rolePK;
        this.createdAt = createdAt;
    }
}
