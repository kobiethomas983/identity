package com.app.identity.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ps_org", schema = "public")
public class Org {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "org_id")
    private String orgId;

    @Column(name = "company_name")
    private String companyName;

    private String description;
    private String website;
    private String address;
}
