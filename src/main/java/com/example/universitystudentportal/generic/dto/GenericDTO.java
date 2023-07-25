package com.example.universitystudentportal.generic.dto;

import com.example.universitystudentportal.model.Gender;
import com.example.universitystudentportal.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Gender gender;

    private Long mobileNumber;

    private Role role;
}
