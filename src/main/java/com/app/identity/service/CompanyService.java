package com.app.identity.service;

import com.app.identity.exception.DataNotFoundException;
import com.app.identity.model.Company;
import com.app.identity.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company save(Company company) {
        String companyId = "Co" + UUID.randomUUID();
        company.setCompanyId(companyId.substring(0,6));
        return companyRepository.save(company);
    }

    public List<Company> save(List<Company> companies) {
        return companies.stream().map(company -> save(company))
                .collect(Collectors.toList());
    }

    public Company getByCompanyId(String companyId) {
        return companyRepository.findByCompanyId(companyId);
    }

    public Company update(String companyId, Company updateCompany) {
        Company foundCompany = getByCompanyId(companyId);
        if (foundCompany == null) {
            throw new DataNotFoundException("No such company exist with id: " + companyId);
        }
        if (updateCompany.getCompanyName() != null) {
            foundCompany.setCompanyName(updateCompany.getCompanyName());
        }
        if (updateCompany.getAddress() != null) {
            foundCompany.setAddress(updateCompany.getAddress());
        }
        if (updateCompany.getDescription() != null) {
            foundCompany.setDescription(updateCompany.getDescription());
        }
        if (updateCompany.getWebsite() != null) {
            foundCompany.setWebsite(updateCompany.getWebsite());
        }
        return companyRepository.save(foundCompany);
    }

    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }
}
