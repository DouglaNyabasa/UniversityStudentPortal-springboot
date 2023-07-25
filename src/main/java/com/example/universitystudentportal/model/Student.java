package com.example.universitystudentportal.model;

import com.example.universitystudentportal.customeAnnotations.ValidateRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

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

    @Column(name = "MobileNumber",unique = true,nullable = false)
    @NotBlank(message = "mobileNumber should not be blank !!!")
    private Long mobileNumber;

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
