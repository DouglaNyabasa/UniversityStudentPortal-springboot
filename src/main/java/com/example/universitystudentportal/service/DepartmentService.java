package com.example.universitystudentportal.service;

import com.example.universitystudentportal.dto.DepartmentDTO;
import com.example.universitystudentportal.generics.repository.GenericRepository;
import com.example.universitystudentportal.generics.service.GenericService;
import com.example.universitystudentportal.mapper.DepartmentMapper;
import com.example.universitystudentportal.model.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends GenericService<Department,Long, DepartmentDTO> {
    protected DepartmentService(GenericRepository<Department> repository) {
        super(repository);
    }
}
