package com.example.universitystudentportal.service;
import com.example.universitystudentportal.dto.AdminDTO;
import com.example.universitystudentportal.dto.LoginRequest;
import com.example.universitystudentportal.generics.repository.GenericRepository;
import com.example.universitystudentportal.generics.service.GenericService;
import com.example.universitystudentportal.model.Admin;
import com.example.universitystudentportal.repository.AdminRepository;
import com.example.universitystudentportal.response.ApiResponse;
import com.example.universitystudentportal.response.AuthenticatedUser;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService extends GenericService<Admin,Long,AdminDTO> {

    private final AdminRepository adminRepository;


    protected AdminService(GenericRepository<Admin> repository, AdminRepository adminRepository) {
        super(repository);
        this.adminRepository = adminRepository;
    }

    public ResponseEntity<?> registerAdmin(AdminDTO adminDTO){
        Admin admin = new Admin();
        admin.setFirstName(adminDTO.getFirstName());
        admin.setLastName(adminDTO.getLastName());
        admin.setEmail(adminDTO.getEmail());
        admin.setRole(adminDTO.getRole());
        adminRepository.save(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body("Admin Successfully Created " + admin);
    }

//    public ResponseEntity<?> signIn(@NonNull LoginRequest loginRequest) {
//        Optional<T> user = repository.findById(Long.valueOf(loginRequest.getEmail()));
//        if (!user.isPresent()) {
//            return ResponseEntity.badRequest()
//                    .body(new ApiResponse(false, "Invalid username or password."));
//        }
//
//        if (!passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body(new ApiResponse(false, "Invalid username or password."));
//        }
//        AuthenticatedUser authenticatedUser = new AuthenticatedUser();
//        authenticatedUser.setId(String.valueOf(user.get().getId()));
//        authenticatedUser.getUsername(user.get().getUserName());
//
//        return repository.save(user);
//    }
}
