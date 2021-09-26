package com.app.identity.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ps_permission", schema = "public")
public class Permission {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "permission_id")
    private String permissionId;
}
