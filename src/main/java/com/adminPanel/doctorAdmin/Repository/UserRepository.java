package com.adminPanel.doctorAdmin.Repository;

import com.adminPanel.doctorAdmin.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
