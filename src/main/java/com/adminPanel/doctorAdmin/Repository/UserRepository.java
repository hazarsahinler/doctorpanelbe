package com.adminPanel.doctorAdmin.Repository;

import com.adminPanel.doctorAdmin.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {


}
