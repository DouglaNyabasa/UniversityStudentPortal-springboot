package com.example.universitystudentportal.model;

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

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "guardian_table")
public class GuardianDetails extends BaseID implements Serializable {

    @Column(name = "FirstName")
    @NotBlank(message = "firstName should not be blank !!!")
    private String firstName;

    @NotBlank(message = "lastName should not be blank !!!")
    @Column(name = "LastName")
    private String lastName;

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
}
