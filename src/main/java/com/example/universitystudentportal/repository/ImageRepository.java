package com.example.universitystudentportal.repository;

import com.example.universitystudentportal.generic.repository.GenericRepository;
import com.example.universitystudentportal.model.StudentImage;

import java.util.Optional;

public interface ImageRepository extends GenericRepository<StudentImage> {

    Optional<StudentImage> findByName(String name);
}
