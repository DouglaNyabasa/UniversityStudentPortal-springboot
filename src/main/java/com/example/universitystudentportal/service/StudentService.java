package com.example.universitystudentportal.service;
import com.example.universitystudentportal.dto.RegisterStudentDTO;
import com.example.universitystudentportal.dto.StudentRequest;
import com.example.universitystudentportal.generics.repository.GenericRepository;
import com.example.universitystudentportal.generics.service.GenericService;
import com.example.universitystudentportal.mapper.StudentMapper;
import com.example.universitystudentportal.model.Student;
import com.example.universitystudentportal.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends GenericService<Student,Long, StudentRequest> {


    final private StudentRepository studentRepository;
    final private ImageRepository imageRepository;
    final private GuardianDetailsRepository guardianDetailsRepository;
    final private FeesPaymentRepository feesPaymentRepository;
    final private ResultsSheetRepository resultsSheetRepository;
    final private ModuleRepository moduleRepository;



    protected StudentService(GenericRepository<Student> repository, StudentRepository studentRepository, ImageRepository imageRepository, GuardianDetailsRepository guardianDetailsRepository, FeesPaymentRepository feesPaymentRepository, ResultsSheetRepository resultsSheetRepository, ModuleRepository moduleRepository) {
        super(repository);
        this.studentRepository = studentRepository;
        this.imageRepository = imageRepository;
        this.guardianDetailsRepository = guardianDetailsRepository;
        this.feesPaymentRepository = feesPaymentRepository;
        this.resultsSheetRepository = resultsSheetRepository;
        this.moduleRepository = moduleRepository;
    }

    public ResponseEntity<?> registerStudent(RegisterStudentDTO registerStudentDTO){
        Student student = new Student();
        student.setFirstName(registerStudentDTO.getFirstName());
        student.setLastName(registerStudentDTO.getLastName());
        student.setEmail(registerStudentDTO.getEmail());
        student.setStudentImage(registerStudentDTO.getStudentImage());
        student.setAddress(registerStudentDTO.getAddress());
        student.setDateOfBirth(registerStudentDTO.getDateOfBirth());
        student.setGender(registerStudentDTO.getGender());
        student.setEnrollmentType(registerStudentDTO.getEnrollmentType());
        student.setMobileNumber(registerStudentDTO.getMobileNumber());
        student.setRole(registerStudentDTO.getRole());
          studentRepository.save(student);
          return ResponseEntity.status(HttpStatus.CREATED).body("Student Successfully Created " + student);
    }

//    private RegisterStudentDTO convertEntityToDTO(Student student){
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
//        RegisterStudentDTO registerStudentDTO = new RegisterStudentDTO();
//        registerStudentDTO = modelMapper.map(student,RegisterStudentDTO.class);
//        return registerStudentDTO;
//    }

}
