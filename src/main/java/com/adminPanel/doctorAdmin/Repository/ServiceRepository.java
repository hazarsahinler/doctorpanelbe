package com.adminPanel.doctorAdmin.Repository;

import com.adminPanel.doctorAdmin.Entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    List<Service> findServicesByDoctorsId(Integer doctorId);
}