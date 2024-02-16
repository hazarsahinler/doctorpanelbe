package com.adminPanel.doctorAdmin.Repository;

import com.adminPanel.doctorAdmin.Entity.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandRepository extends JpaRepository<Demand, Integer> {
    List<Demand> findDemandsByDoctorId(Integer doctorId);

}
