package com.example.universitystudentportal.service;
import com.example.universitystudentportal.dto.AdminDTO;
import com.example.universitystudentportal.generics.repository.GenericRepository;
import com.example.universitystudentportal.generics.service.GenericService;
import com.example.universitystudentportal.mapper.AdminMapper;
import com.example.universitystudentportal.model.Admin;
import com.example.universitystudentportal.repository.AdminRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

}
