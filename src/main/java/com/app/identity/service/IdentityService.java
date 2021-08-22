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

    @Autowired
    public IdentityService(IdentityRepository identityRepository) {
        this.identityRepository = identityRepository;
    }

    public List<Identity> getAll() {
        return identityRepository.findAll();
    }

    public Identity getByFirstName(String firstName) {
        return identityRepository.findByFirstName(firstName);
    }

    public Identity createIdentity(Identity newIdentity) {
        String identityId = UUID.randomUUID().toString();
        newIdentity.setIdentityId(identityId.substring(0,6));
        return identityRepository.save(newIdentity);
    }

    public List<Identity> createIdentities(List<Identity> identities) {
        return identities.stream()
                .map(this::createIdentity)
                .collect(Collectors.toList());
    }

    public Identity getIdentityById(Long id) {
        return identityRepository.findById(id).orElse(null);
    }

    public Identity updatedIdentity(Long id, Identity updatedIdentity) {
        Identity identity = getIdentityById(id);
        if (identity == null) {
            throw new DataNotFoundException("No such identity exist with id: " + id);
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
}
