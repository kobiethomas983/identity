package com.app.identity.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "ps_identity", schema = "public")
public class Identity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "identity_id")
    private String identityId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "company_id")
    @NotBlank(message = "companyId cannot be blank")
    private String companyId;

    private String role;

    public Identity() {};

    public Identity(String firstName, String lastName,
                    String phone, String email, String companyId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.companyId = companyId;
    }
}
