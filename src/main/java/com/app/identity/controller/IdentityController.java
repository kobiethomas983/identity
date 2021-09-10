package com.app.identity.controller;

import com.app.identity.model.Identity;
import com.app.identity.model.IdentityRole;
import com.app.identity.service.IdentityRoleService;
import com.app.identity.service.IdentityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "Identity Controller", description = "Identity Service API : Identity 2.0 service", tags = "Identity")
@Validated
public class IdentityController {
    private final IdentityService identityService;
    private final IdentityRoleService identityRoleService;

    @Autowired
    public IdentityController(IdentityService identityService,
                              IdentityRoleService identityRoleService) {
        this.identityService = identityService;
        this.identityRoleService = identityRoleService;
    }

    @GetMapping("/identities")
    @ApiOperation(value = "Get a list of Identities", nickname = "findIdentities", response = Identity.class, responseContainer = "List", tags = "Get Methods")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 404, message = "Not found!!!"),
            @ApiResponse(code = 422, message = "Incorrect parameter data")
    })
    public List<Identity> getAll() {
        return identityService.getAll();
    }

    @GetMapping("/identities/{id}")
    @ApiOperation(value = "Get a Identity by ids", nickname = "findIdentityById", tags = "Get Methods")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 404, message = "Not found!!!"),
            @ApiResponse(code = 422, message = "Incorrect parameter data")
    })
    public Identity getIdentityById(@PathVariable("id") String identityId) {
        return identityService.getIdentityById(identityId);
    }

    @PostMapping("/identities")
    @ApiOperation(value = "Add a Identity", nickname = "saveIdentity", tags = "Add Methods")
    public Identity createIdentity(@Valid @RequestBody Identity newIdentity) {
        return identityService.createIdentity(newIdentity);
    }

    @PutMapping("/identities/{id}")
    @ApiOperation(value = "Update Identity", nickname = "updateIdentity", tags = "Update Methods")
    public Identity updatedIdentity(@PathVariable("id") String identity,
                                    @RequestBody Identity updatedIdentity) {
       return identityService.updatedIdentity(identity, updatedIdentity);
    }
    @GetMapping("identities/email/{email}")
    @ApiOperation(value = "Get a Identity by email", nickname = "findIdentityByEmail", tags = "Get Methods")
    public Identity getIdentityByFirstName(@PathVariable("email") String email) {
        return identityService.getByFirstName(email);
    }

    @DeleteMapping("/identities")
    @ApiOperation(value = "Delete all identities", nickname = "deleteIdentities", tags = "Delete Methods")
    public void deleteIdentities() {
        identityService.deleteIdentities();
    }

    @PostMapping("/identities/{identityId}/roles/{roleId}")
    public IdentityRole addRoleToIdentity(@PathVariable("identityId") String identityId,
                                          @PathVariable("roleId") String roleId) {
        return identityRoleService.addRoleToIdentity(identityId, roleId);
    }
}
