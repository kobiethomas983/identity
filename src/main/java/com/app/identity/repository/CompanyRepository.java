package com.app.identity.repository;

import com.app.identity.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByCompanyName(String companyName);
    List<Company> findAll();
    Company findByCompanyId(String companyId);
}
