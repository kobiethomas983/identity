package com.app.identity.repository;

import com.app.identity.model.Org;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgRepository extends JpaRepository<Org, Long> {
    Org findByCompanyName(String companyName);
    List<Org> findAll();
}
