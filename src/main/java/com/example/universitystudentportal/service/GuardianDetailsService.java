package com.example.universitystudentportal.service;

import com.example.universitystudentportal.dto.GuardianDTO;
import com.example.universitystudentportal.generics.mapper.EntityMapper;
import com.example.universitystudentportal.generics.repository.GenericRepository;
import com.example.universitystudentportal.generics.service.GenericService;
import com.example.universitystudentportal.mapper.GuardianDetailsMapper;
import com.example.universitystudentportal.model.GuardianDetails;
import com.example.universitystudentportal.repository.GuardianDetailsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GuardianDetailsService extends GenericService<GuardianDetails,Long,GuardianDTO> {

    private final GuardianDetailsRepository guardianDetailsRepository;
    protected GuardianDetailsService(GenericRepository<GuardianDetails> repository, GuardianDetailsRepository guardianDetailsRepository) {
        super(repository);
        this.guardianDetailsRepository = guardianDetailsRepository;
    }

    public ResponseEntity<?> addGuardian(GuardianDTO guardianDTO){
        GuardianDetails guardian = new GuardianDetails();
        guardian.setFirstName(guardianDTO.getFirstName());
        guardian.setLastName(guardianDTO.getLastName());
        guardian.setEmail(guardianDTO.getEmail());
        guardian.setMobileNumber(guardianDTO.getMobileNumber());
        guardian.setGender(guardianDTO.getGender());
        guardianDetailsRepository.save(guardian);
        return ResponseEntity.status(HttpStatus.CREATED).body("Guardian Successfully Added"+guardian);

    }
}
