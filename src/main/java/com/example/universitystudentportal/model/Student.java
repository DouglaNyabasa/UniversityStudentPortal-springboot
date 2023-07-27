package com.example.universitystudentportal.model;

import com.example.universitystudentportal.customeAnnotations.ValidateEnrollmentType;
import com.example.universitystudentportal.customeAnnotations.ValidateRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Douglas Nybasa
 * created on 7/20/2023
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "student_table")
public class Student extends BaseID  implements Serializable {

    private static final long serialVersionUID = 1L;


    @Column(name = "FirstName")
    @NotBlank(message = "firstName should not be blank !!!")
    private String firstName;

    @NotBlank(message = "lastName should not be blank !!!")
    @Column(name = "LastName")
    private String lastName;


    @ValidateRole(message = "Invalid Role : It should be either ADMIN ,STUDENT or LECTURER")
    @NotBlank(message = "role should not be blank !!!")
    @Column(name = "Role",nullable = false)
    private Role role;

    @Enumerated
    @ValidateEnrollmentType(message = "Invalid EnrollmentType : It should be either BLOCK ,CONVENTIONAL or WEEKEND")
    private EnrollmentType enrollmentType;

    @Column(name = "MobileNumber",unique = true,nullable = false)
    @NotBlank(message = "mobileNumber should not be blank !!!")
    private Long mobileNumber;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentImage_id", nullable = false)
    @NotBlank(message = "studentImage should not be blank !!!")
    private StudentImage studentImage;

    @DateTimeFormat
    @Column(name = "dob",nullable = false)
    @NotBlank(message = "please enter date of birth")
    private Date dateOfBirth;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private FeesPayment feesPayment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guardian_id", nullable = false)
    private GuardianDetails guardianDetails;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_id")
    private Exam exam;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "results_id")
    private List <ResultsSheet> resultsSheet;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    private Level level;

    @NotBlank
    @Column(name = "Address",unique = true)
    private String address;

    @Email
    @NotBlank(message = "email should not be blank !!!")
    @Column(name = "Email",unique = true,nullable = false)
    private String email;

    @NotBlank(message = "gender should not be blank !!!")
    @Column(name = "Gender",nullable = false)
    private Gender gender;

    @NotBlank(message = "password should not be blank !!!")
    @Column(name = "Password",nullable = false)
    private String password;


}
