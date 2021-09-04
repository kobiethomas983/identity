package com.app.identity.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ps_company", schema = "public")
public class Company {

    public Company() {}

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "company_id")
    private String companyId;

    @Column(name = "company_name")
    private String companyName;

    private String description;
    private String website;
    private String address;
}
