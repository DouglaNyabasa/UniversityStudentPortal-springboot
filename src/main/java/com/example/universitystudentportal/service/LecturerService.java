package com.example.universitystudentportal.service;
import com.example.universitystudentportal.dto.LecturerDTO;
import com.example.universitystudentportal.generics.repository.GenericRepository;
import com.example.universitystudentportal.generics.service.GenericService;
import com.example.universitystudentportal.mapper.LecturerMapper;
import com.example.universitystudentportal.model.Lecturer;
import com.example.universitystudentportal.repository.LecturerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service

public class LecturerService extends GenericService<Lecturer,Long,LecturerDTO> {


    private final LecturerRepository lecturerRepository;
    protected LecturerService(GenericRepository<Lecturer> repository, LecturerRepository lecturerRepository) {
        super(repository);
        this.lecturerRepository = lecturerRepository;
    }

    public ResponseEntity<?> registerLecturer(LecturerDTO lecturerDTO){
        Lecturer lecturer = new Lecturer();
        lecturer.setFirstName(lecturerDTO.getFirstName());
        lecturer.setLastName(lecturerDTO.getLastName());
        lecturer.setEmail(lecturerDTO.getEmail());
        lecturer.setRole(lecturerDTO.getRole());
        lecturer.setModule(lecturerDTO.getModule());
        lecturerRepository.save(lecturer);
        return ResponseEntity.status(HttpStatus.CREATED).body("Lecturer Successfully Created " + lecturer);
    }
}
