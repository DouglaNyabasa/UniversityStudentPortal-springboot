package com.example.universitystudentportal.service;

import com.example.universitystudentportal.dto.ResultsSheetDTO;
import com.example.universitystudentportal.generics.repository.GenericRepository;
import com.example.universitystudentportal.generics.service.GenericService;
import com.example.universitystudentportal.model.ResultsSheet;
import org.springframework.stereotype.Service;

@Service
public class ResultsSheetService extends GenericService<ResultsSheet,Long, ResultsSheetDTO> {
    protected ResultsSheetService(GenericRepository<ResultsSheet> repository) {
        super(repository);
    }
}
