package com.app.identity.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class IdentityRolePK implements Serializable {

    @Column(name = "identity_id", nullable = false)
    private String identityId;

    @Column(name = "role_id", nullable = false)
    private String roleId;

    public IdentityRolePK() {}

    public IdentityRolePK(String identityId, String roleId) {
        this.identityId = identityId;
        this.roleId = roleId;
    }
}
