package com.adminPanel.doctorAdmin.Repository;

import com.adminPanel.doctorAdmin.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findDoctorsByServiceId(Integer serviceId);

}
