package com.adminPanel.doctorAdmin.Repository;

import com.adminPanel.doctorAdmin.Entity.Talep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TalepRepository extends JpaRepository<Talep,Integer> {
    List<Talep> findByUserId(Integer userId);
}
