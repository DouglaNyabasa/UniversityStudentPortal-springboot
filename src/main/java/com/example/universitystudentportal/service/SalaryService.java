package com.example.universitystudentportal.service;

import com.example.universitystudentportal.dto.SalaryDTO;
import com.example.universitystudentportal.generics.repository.GenericRepository;
import com.example.universitystudentportal.generics.service.GenericService;
import com.example.universitystudentportal.model.Lecturer;
import com.example.universitystudentportal.model.Salary;
import com.example.universitystudentportal.model.Taxation;
import com.example.universitystudentportal.repository.LecturerRepository;
import com.example.universitystudentportal.repository.SalaryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SalaryService extends GenericService<Salary,Long, SalaryDTO> {

    private final SalaryRepository salaryRepository;
    private final TaxationService taxationService;

    private final LecturerRepository lecturerRepository;
    protected SalaryService(GenericRepository<Salary> repository, SalaryRepository salaryRepository, TaxationService taxationService, LecturerRepository lecturerRepository) {
        super(repository);
        this.salaryRepository = salaryRepository;
        this.taxationService = taxationService;
        this.lecturerRepository = lecturerRepository;
    }
    public Salary createOrUpdateSalary(Salary salary, Lecturer lecturer) {
        Optional<Salary> salary1 = salaryRepository.findSalaryById(salary.getId());

        if (salary1.isEmpty()) {
            Salary salary2 = new Salary();

            for (Taxation taxation :taxationService.findAllTaxes()){

                if (salary.getGrossAmount()>=taxation.getTaxMinAmount()&& salary.getGrossAmount()<=taxation.getTaxMaxAmount()){
                    double taxAmount = (taxation.getTaxPercentage()/100) * (salary.getGrossAmount());
                    double netAmount = salary.getGrossAmount()-salary.getDeduction()-taxAmount;

                    System.err.println("Tax Amount::"+taxAmount);
                    System.err.println("Net Amount::"+netAmount);
                    salary2.setTaxAmount(taxAmount);
                    salary2.setNetAmount(netAmount);


                }else {
                    double netAmount = salary.getGrossAmount()-salary.getDeduction();
                    salary2.setNetAmount(netAmount);
                    salary2.setTaxAmount(0);
                }
            }

            salary2.setDateProcessed(salary.getDateProcessed());
            salary2.setDeduction(salary.getDeduction());
            salary2.setGrossAmount(salary.getGrossAmount());
            salary2.setPeriod(salary.getPeriod());
            salary2.setLecturer(lecturer);
            salary2 = salaryRepository.save(salary2);
            return salary2;

        }
        return null;
    }
}
