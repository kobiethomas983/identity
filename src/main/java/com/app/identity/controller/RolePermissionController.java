package com.app.identity.controller;

import com.app.identity.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
public class RolePermissionController {
    private final RolePermissionService rolePermissionService;

    @Autowired
    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    @GetMapping("/role-permissions/{roleId}")
    public List<String> getAllPermissionsByRoleId(@PathVariable("roleId") String roleId) {
        return rolePermissionService.getPermissionsByRoleId(roleId);
    }
}
