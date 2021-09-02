package com.app.identity.service;

import com.app.identity.exception.DataNotFoundException;
import com.app.identity.model.Identity;
import com.app.identity.repository.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class IdentityService {

    private final IdentityRepository identityRepository;
    private final CompanyService companyService;

    @Autowired
    public IdentityService(IdentityRepository identityRepository, CompanyService companyService) {
        this.identityRepository = identityRepository;
        this.companyService = companyService;
    }

    public List<Identity> getAll() {
        return identityRepository.findAll();
    }

    public Identity getByFirstName(String firstName) {
        return identityRepository.findByFirstName(firstName);
    }

    public Identity createIdentity(Identity newIdentity) {
        String identityId = "Id" + UUID.randomUUID();
        newIdentity.setIdentityId(identityId.substring(0,6));
        String companyId = newIdentity.getCompanyId();
        if (companyService.getByCompanyId(companyId) == null) {
            throw new DataNotFoundException("No company exist with id: " + companyId);
        }
        return identityRepository.save(newIdentity);
    }

    public List<Identity> createIdentities(List<Identity> identities) {
        return identities.stream()
                .map(this::createIdentity)
                .collect(Collectors.toList());
    }

    public Identity getIdentityById(String identityId) {
        return identityRepository.findByIdentityId(identityId);
    }

    public Identity updatedIdentity(String identityId, Identity updatedIdentity) {
        Identity identity = getIdentityById(identityId);
        if (identity == null) {
            throw new DataNotFoundException("No such identity exist with id: " + identityId);
        }
        if (updatedIdentity.getFirstName() != null) {
            identity.setFirstName(updatedIdentity.getFirstName());
        }
        if (updatedIdentity.getLastName() != null) {
            identity.setLastName(updatedIdentity.getLastName());
        }
        if (updatedIdentity.getPhone() != null) {
            identity.setPhone(updatedIdentity.getPhone());
        }
        return identityRepository.save(identity);
    }

    public void deleteIdentities() {
        identityRepository.deleteAll();
    }

    public List<Identity> getIdentitiesByCompanyId(String companyId) {
        return identityRepository.findByCompanyId(companyId);
    }

    public Identity getIdentityByEmail(String email) {
        return identityRepository.findByEmail(email);
    }
}
