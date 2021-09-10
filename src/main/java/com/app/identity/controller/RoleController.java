package com.app.identity.controller;

import com.app.identity.model.Identity;
import com.app.identity.model.Role;
import com.app.identity.service.RoleService;
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
@Api(value = "Role Controller", tags = "Role")
@Validated
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    @ApiOperation(value = "Get a list of roles", nickname = "findRoles", response = Role.class, responseContainer = "List", tags = "Get Methods")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 404, message = "Not found!!!"),
            @ApiResponse(code = 422, message = "Incorrect parameter data")
    })
    public List<Role> getAll() {
        return roleService.findRoles();
    }

    @GetMapping("/roles/{roleId}")
    @ApiOperation(value = "Get a role by id", nickname = "findRoleById", tags = "Get Methods")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 404, message = "Not found!!!"),
            @ApiResponse(code = 422, message = "Incorrect parameter data")
    })
    public Role getRoleById(@PathVariable("roleId") String roleId) {
        return roleService.findRole(roleId);
    }

    @PostMapping("/roles")
    @ApiOperation(value = "Add a Role", nickname = "saveRole", tags = "Add Methods")
    public Role createRole(@Valid @RequestBody Role role) {
        return roleService.save(role);
    }
}
