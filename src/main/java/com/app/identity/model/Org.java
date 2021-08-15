package com.app.identity.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ps_org", schema = "public")
public class Org {

    @Id
    @GeneratedValue
    private Long id;

    private String companyName;
    private String description;
    private String website;
    private String address;
}
