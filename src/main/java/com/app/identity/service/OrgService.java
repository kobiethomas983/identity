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
        String orgId = "Og" + UUID.randomUUID();
        org.setOrgId(orgId.substring(0,6));
        return orgRepository.save(org);
    }

    public List<Org> save(List<Org> orgs) {
        return orgs.stream().map(org -> save(org))
                .collect(Collectors.toList());
    }

    public Org getByOrgId(String orgId) {
        return orgRepository.findByOrgId(orgId);
    }

    public Org update(String orgId, Org updateOrg) {
        Org foundOrg = getByOrgId(orgId);
        if (foundOrg == null) {
            throw new DataNotFoundException("No such org exist with id: " + orgId);
        }
        if (updateOrg.getCompanyName() != null) {
            foundOrg.setCompanyName(updateOrg.getCompanyName());
        }
        if (updateOrg.getAddress() != null) {
            foundOrg.setAddress(updateOrg.getAddress());
        }
        if (updateOrg.getDescription() != null) {
            foundOrg.setDescription(updateOrg.getDescription());
        }
        if (updateOrg.getWebsite() != null) {
            foundOrg.setWebsite(updateOrg.getWebsite());
        }
        return orgRepository.save(foundOrg);
    }

    public void deleteOrgById(Long id) {
        orgRepository.deleteById(id);
    }

    public List<Org> getAll() {
        return orgRepository.findAll();
    }
}
