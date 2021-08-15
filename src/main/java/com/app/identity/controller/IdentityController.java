package com.app.identity.controller;

import com.app.identity.model.Identity;
import com.app.identity.service.IdentityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Identity Controller", description = "Identity Service API : Identity 2.0 service", tags = "Identity")
public class IdentityController {

    private final IdentityService identityService;

    @Autowired
    public IdentityController(IdentityService identityService) {
        this.identityService = identityService;
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
        System.out.println("Shows that it updates");
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
    public Identity getIdentityById(@PathVariable("id") String id) {
        return identityService.getIdentityById(id);
    }

    @PostMapping("/identities")
    @ApiOperation(value = "Add a Identity", nickname = "saveIdentity", tags = "Add Methods")
    public Identity createIdentity(@RequestBody Identity newIdentity) {
        return identityService.createIdentity(newIdentity);
    }

    @PutMapping("/identities/{id}")
    @ApiOperation(value = "Update Identity", nickname = "updateIdentity", tags = "Update Methods")
    public Identity updatedIdentity(@PathVariable("id") String id,
                                    @RequestBody Identity updatedIdentity) {
       return identityService.updatedIdentity(id, updatedIdentity);
    }

    @GetMapping("identities/firstName/{firstName}")
    @ApiOperation(value = "Get a Identity by firstName", nickname = "findIdentityByFirstName", tags = "Get Methods")
    public Identity getIdentityByFirstName(@PathVariable("firstName") String firstName) {
        return identityService.getByFirstName(firstName);
    }

    @DeleteMapping("/identities")
    @ApiOperation(value = "Delete all identities", nickname = "deleteIdentities", tags = "Delete Methods")
    public void deleteIdentities() {
        identityService.deleteIdentities();
    }

}
