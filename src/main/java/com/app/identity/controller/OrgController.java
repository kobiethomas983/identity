package com.app.identity.controller;

import com.app.identity.exception.DataNotFoundException;
import com.app.identity.model.Org;
import com.app.identity.service.OrgService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Org Controller", tags = "Org")
public class OrgController {

    private final OrgService orgService;

    @Autowired
    public OrgController(OrgService orgService) {
        this.orgService = orgService;
    }

    @GetMapping("/orgs")
    public List<Org> getAll() {
        return orgService.getAll();
    }

    @GetMapping("/orgs/{id}")
    public Org getOrgById(@PathVariable("id") long id) {
        Org org = orgService.findById(id);
        if (org == null) {
            throw new DataNotFoundException("Org doesn't exist with id: " + id);
        }
        return org;
    }

    @PutMapping("/orgs/{id}")
    public Org updateOrg(@PathVariable("id") long id, @RequestBody Org org) {
        return orgService.update(id, org);
    }

    @PostMapping("/orgs")
    public Org createOrg(@RequestBody Org org) {
        return orgService.save(org);
    }


}