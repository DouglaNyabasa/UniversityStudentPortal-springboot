package com.example.universitystudentportal.dto;

import com.example.universitystudentportal.generics.dto.GenericDTO;
import com.example.universitystudentportal.model.EnrollmentType;
import com.example.universitystudentportal.model.StudentImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Enumerated;
import java.util.Date;

/**
 *
 * @author Douglas Nybasa
 * created on 7/20/2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterStudentDTO extends GenericDTO {

    private String address;
    private Date dateOfBirth;
    @Enumerated
    private EnrollmentType enrollmentType;
    private StudentImage studentImage;
    private String password;
}
