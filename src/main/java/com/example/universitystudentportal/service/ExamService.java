package com.example.universitystudentportal.service;

import com.example.universitystudentportal.dto.ExamDTO;
import com.example.universitystudentportal.generics.repository.GenericRepository;
import com.example.universitystudentportal.generics.service.GenericService;
import com.example.universitystudentportal.model.Exam;
import org.springframework.stereotype.Service;

@Service
public class ExamService extends GenericService<Exam,Long, ExamDTO> {
    protected ExamService(GenericRepository<Exam> repository) {
        super(repository);
    }
}
