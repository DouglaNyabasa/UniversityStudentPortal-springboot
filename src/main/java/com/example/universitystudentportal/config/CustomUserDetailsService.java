//package com.example.universitystudentportal.config;
//
//import com.example.universitystudentportal.model.Admin;
//import com.example.universitystudentportal.model.BaseID;
//import com.example.universitystudentportal.model.Lecturer;
//import com.example.universitystudentportal.model.Student;
//import com.example.universitystudentportal.repository.AdminRepository;
//import com.example.universitystudentportal.repository.LecturerRepository;
//import com.example.universitystudentportal.repository.StudentRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomUserDetailsService extends BaseID implements UserDetailsService {
//
//
//    private StudentRepository studentRepository;
//    private LecturerRepository lecturerRepository;
//    private AdminRepository adminRepository;
//
//    public CustomUserDetailsService(StudentRepository studentRepository, LecturerRepository lecturerRepository, AdminRepository adminRepository) {
//        this.studentRepository = studentRepository;
//        this.lecturerRepository = lecturerRepository;
//        this.adminRepository = adminRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Student student = studentRepository.findByUsername(username);
//        Lecturer lecturer = lecturerRepository.findByUsername(username);
//        Admin admin = adminRepository.findByUsername(username);
//        if (student == null | admin == null ){
//            throw new UsernameNotFoundException("USER NOT FOUND");
//        }
//        return null;
//    }
//}
