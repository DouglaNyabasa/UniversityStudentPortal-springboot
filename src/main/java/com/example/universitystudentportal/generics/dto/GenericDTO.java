package com.example.universitystudentportal.generics.dto;

import com.example.universitystudentportal.model.Gender;
import com.example.universitystudentportal.model.Role;
import lombok.*;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@MappedSuperclass
@NoArgsConstructor
public class GenericDTO implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Gender gender;

    private Long mobileNumber;

    private Role role;
}
