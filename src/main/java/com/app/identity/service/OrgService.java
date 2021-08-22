package com.app.identity.service;

import com.app.identity.exception.DataNotFoundException;
import com.app.identity.model.Org;
import com.app.identity.repository.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrgService {

    private final OrgRepository orgRepository;

    @Autowired
    public OrgService(OrgRepository orgRepository) {
        this.orgRepository = orgRepository;
    }

    public Org save(Org org) {
        String orgId = UUID.randomUUID().toString();
        org.setOrgId(orgId.substring(0,6));
        return orgRepository.save(org);
    }

    public List<Org> save(List<Org> orgs) {
        return orgs.stream().map(org -> save(org))
                .collect(Collectors.toList());
    }

    public Org findById(Long id) {
        return orgRepository.findById(id)
                .orElse(null);
    }

    public Org update(Long id, Org updateOrg) {
        Optional<Org> foundOrg = orgRepository.findById(id);
        if (!foundOrg.isPresent()) {
            throw new DataNotFoundException("No such org exist with id: " + id);
        }
        Org org = foundOrg.get();
        if (updateOrg.getCompanyName() != null) {
            org.setCompanyName(updateOrg.getCompanyName());
        }
        if (updateOrg.getAddress() != null) {
            org.setAddress(updateOrg.getAddress());
        }
        if (updateOrg.getDescription() != null) {
            org.setDescription(updateOrg.getDescription());
        }
        if (updateOrg.getWebsite() != null) {
            org.setWebsite(updateOrg.getWebsite());
        }
        return orgRepository.save(org);
    }

    public void deleteOrgById(Long id) {
        orgRepository.deleteById(id);
    }

    public List<Org> getAll() {
        return orgRepository.findAll();
    }
}
