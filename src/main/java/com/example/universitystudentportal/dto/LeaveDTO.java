package com.example.universitystudentportal.dto;

import com.example.universitystudentportal.customeAnnotations.ValidateLeaveType;
import com.example.universitystudentportal.generics.dto.GenericDTO;
import com.example.universitystudentportal.model.LeaveStatus;
import com.example.universitystudentportal.model.LeaveType;
import com.example.universitystudentportal.model.Lecturer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LeaveDTO extends GenericDTO {

    @Column(name = "requestedDays",nullable = false)
    @NotBlank(message = "Requested Leave Days should not be blank !!!")
    private String requestedDays;

    @Enumerated
    @ValidateLeaveType(message = "Invalid Leave Type please Try Again : It should be either UNPAID_LEAVE ,VACATION_LEAVE or SICK_LEAVE")
    private LeaveType leaveType;

    @Column(name = "startDate",nullable = false)
    @NotBlank(message = "Start date for the Leave Days should not be blank !!!")
    private LocalDate startDate;

    @Column(name = "endDate",nullable = false)
    @NotBlank(message = "end date for the Leave Days should not be blank !!!")
    private LocalDate endDate;

    private int duration;

    @ManyToOne
    private Lecturer lecturer;

    @Enumerated
    private LeaveStatus Status;
}
