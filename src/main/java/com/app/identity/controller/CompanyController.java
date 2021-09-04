package com.app.identity.controller;

import com.app.identity.exception.DataNotFoundException;
import com.app.identity.model.Company;
import com.app.identity.model.Identity;
import com.app.identity.service.IdentityService;
import com.app.identity.service.CompanyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Api(value = "Company Controller", tags = "Company")
public class CompanyController {

    private final CompanyService companyService;
    private final IdentityService identityService;

    @Autowired
    public CompanyController(CompanyService companyService,
                             IdentityService identityService) {
        this.companyService = companyService;
        this.identityService = identityService;
    }

    @GetMapping("/companies")
    public List<Company> getAll() {
        return companyService.getAll();
    }

    @GetMapping("/companies/{id}")
    public Company getCompanyById(@PathVariable("id") String companyId) {
        Company company = companyService.getByCompanyId(companyId);
        if (company == null) {
            throw new DataNotFoundException("Company doesn't exist with id: " + companyId);
        }
        return company;
    }

    @PutMapping("/companies/{id}")
    public Company updateCompany(@PathVariable("id") String companyId, @RequestBody Company company) {
        return companyService.update(companyId, company);
    }

    @PostMapping("/companies")
    public Company createCompany(@RequestBody Company company) {
        return companyService.save(company);
    }

    @GetMapping("/companies/{companyId}/identities")
    public List<Identity> getMembers(@PathVariable("companyId") String companyId) {
        return identityService.getIdentitiesByCompanyId(companyId);
    }

}