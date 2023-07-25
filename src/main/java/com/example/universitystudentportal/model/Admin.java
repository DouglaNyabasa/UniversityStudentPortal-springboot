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
@Table(name = "admin_table")
public class Admin  extends BaseID implements Serializable {

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

    @Email
    @NotBlank(message = "email should not be blank !!!")
    @Column(name = "Email",unique = true,nullable = false)
    private String email;

    @NotBlank(message = "password should not be blank !!!")
    @Column(name = "Password",nullable = false)
    private String password;
}
