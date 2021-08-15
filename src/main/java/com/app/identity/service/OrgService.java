package com.app.identity.service;

import com.app.identity.repository.OrgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgService {

    private final OrgRepository orgRepository;

    @Autowired
    public OrgService(OrgRepository orgRepository) {
        this.orgRepository = orgRepository;
    }
}
