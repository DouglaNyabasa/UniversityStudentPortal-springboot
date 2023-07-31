package com.example.universitystudentportal.repository;

import com.example.universitystudentportal.generics.repository.GenericRepository;
import com.example.universitystudentportal.model.Salary;

import java.util.Optional;

public interface SalaryRepository extends GenericRepository<Salary> {

    Optional<Salary> findSalaryById(Long id);
}
