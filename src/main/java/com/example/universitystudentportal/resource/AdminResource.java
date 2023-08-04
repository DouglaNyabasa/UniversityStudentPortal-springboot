package com.example.universitystudentportal.resource;

import com.example.universitystudentportal.dto.AdminDTO;
import com.example.universitystudentportal.dto.LoginRequest;
import com.example.universitystudentportal.generics.resource.GenericResource;
import com.example.universitystudentportal.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api/admin")
@Slf4j
public class AdminResource {

    private final AdminService adminService;

    public AdminResource(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/register")
    @Operation(
            tags = {"ADMIN ENDPOINTS"},
            summary = "register admin",
            description = "This end point registers the system admin to the portal",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "ENTER THE REQUIRED DETAILS TO CREATE AND SAVE THE ENTITY"),
            parameters = {@Parameter(name = "adminDTO")}
    )
    public ResponseEntity<?> registerAdmin(AdminDTO adminDTO){
        return adminService.registerAdmin(adminDTO);

    }



}
