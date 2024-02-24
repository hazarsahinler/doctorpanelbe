package com.adminPanel.doctorAdmin.ServiceLayer;

import com.adminPanel.doctorAdmin.Entity.Doctor;
import com.adminPanel.doctorAdmin.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorsById(Integer doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElse(null);
        return doctor;
    }



}
