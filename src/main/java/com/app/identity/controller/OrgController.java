package com.app.identity.controller;

import com.app.identity.exception.DataNotFoundException;
import com.app.identity.model.Identity;
import com.app.identity.model.Org;
import com.app.identity.service.IdentityService;
import com.app.identity.service.OrgService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Org Controller", tags = "Org")
public class OrgController {

    private final OrgService orgService;
    private final IdentityService identityService;

    @Autowired
    public OrgController(OrgService orgService,
                         IdentityService identityService) {
        this.orgService = orgService;
        this.identityService = identityService;
    }

    @GetMapping("/orgs")
    public List<Org> getAll() {
        return orgService.getAll();
    }

    @GetMapping("/orgs/{id}")
    public Org getOrgById(@PathVariable("id") String orgId) {
        Org org = orgService.getByOrgId(orgId);
        if (org == null) {
            throw new DataNotFoundException("Org doesn't exist with id: " + orgId);
        }
        return org;
    }

    @PutMapping("/orgs/{id}")
    public Org updateOrg(@PathVariable("id") String orgId, @RequestBody Org org) {
        return orgService.update(orgId, org);
    }

    @PostMapping("/orgs")
    public Org createOrg(@RequestBody Org org) {
        return orgService.save(org);
    }

    @GetMapping("/orgs/{orgId}/identities")
    public List<Identity> getMembers(@PathVariable("orgId") String orgId) {
        return identityService.getIdentitiesByOrgId(orgId);
    }

}