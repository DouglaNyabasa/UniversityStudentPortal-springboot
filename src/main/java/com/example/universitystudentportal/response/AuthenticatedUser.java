package com.example.universitystudentportal.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class AuthenticatedUser {
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
    private String username;
    private String email;
    private String phone;
}