package com.app.identity.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "ps_role")
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "role_id")
    private String roleId;

    private String description;

    @Column(name = "created_at")
    private Timestamp createdAt;
}
