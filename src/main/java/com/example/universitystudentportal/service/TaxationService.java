package com.example.universitystudentportal.service;


import com.example.universitystudentportal.dto.TaxationDTO;
import com.example.universitystudentportal.generics.repository.GenericRepository;
import com.example.universitystudentportal.generics.service.GenericService;
import com.example.universitystudentportal.mapper.TaxMapper;
import com.example.universitystudentportal.model.Taxation;
import com.example.universitystudentportal.repository.TaxationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxationService extends GenericService<Taxation,Long, TaxationDTO> {

    private final TaxationRepository taxationRepository;

    protected TaxationService(GenericRepository<Taxation> repository, TaxationRepository taxationRepository) {
        super(repository);
        this.taxationRepository = taxationRepository;
    }

    public List<Taxation> findAllTaxes(){
        return taxationRepository.findAll();
    }
}
