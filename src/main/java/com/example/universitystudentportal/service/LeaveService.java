package com.example.universitystudentportal.service;

import com.example.universitystudentportal.dto.LeaveDTO;
import com.example.universitystudentportal.generics.repository.GenericRepository;
import com.example.universitystudentportal.generics.service.GenericService;
import com.example.universitystudentportal.model.Leave;
import com.example.universitystudentportal.model.LeaveStatus;
import com.example.universitystudentportal.model.Lecturer;
import com.example.universitystudentportal.repository.LeaveRepository;
import com.example.universitystudentportal.repository.LecturerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class LeaveService  extends GenericService<Leave,Long,LeaveDTO> {

    private final LeaveRepository leaveRepository;
    private final LecturerRepository lecturerRepository;
    protected LeaveService(GenericRepository<Leave> repository, LeaveRepository leaveRepository, LecturerRepository lecturerRepository) {
        super(repository);
        this.leaveRepository = leaveRepository;
        this.lecturerRepository = lecturerRepository;
    }

    public ResponseEntity applyLeave(LeaveDTO leaveDTO){
        Leave leave = new Leave();
        LeaveStatus status = LeaveStatus.PENDING;
        Optional<Lecturer> lecturer = lecturerRepository.findById(leaveDTO.getLecturer().getId());
        leave.setLeaveType(leaveDTO.getLeaveType());
        leave.setStartDate(leaveDTO.getStartDate());
        Period period =Period.between(leaveDTO.getStartDate(),leaveDTO.getEndDate());
        leave.setDuration(period.getDays() + 1);
        leave.setStatus(status);
        leave.setEndDate(leaveDTO.getEndDate());
        leave.setLecturer(lecturer.get());
        leaveRepository.save(leave);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Leave Successfully applied for "+leave);

    }
    public ResponseEntity getAll() {
        List<Leave> leaveList = leaveRepository.findAll();
        List<Leave> filteredLeave = leaveList.stream()
                .filter(leave ->leave.getStatus().
                        equals(LeaveStatus.PENDING)).collect(Collectors.toList());
        return ResponseEntity.ok().body(filteredLeave) ;
    }
}
