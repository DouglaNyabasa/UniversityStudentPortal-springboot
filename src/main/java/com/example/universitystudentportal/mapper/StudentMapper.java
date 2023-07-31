package com.example.universitystudentportal.mapper;

import com.example.universitystudentportal.dto.StudentRequest;

import com.example.universitystudentportal.generics.mapper.EntityMapper;
import com.example.universitystudentportal.model.Student;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface StudentMapper extends EntityMapper<StudentRequest, Student> {
    StudentRequest toDto(Student s);
}
