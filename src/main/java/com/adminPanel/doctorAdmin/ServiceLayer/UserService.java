package com.adminPanel.doctorAdmin.ServiceLayer;

import com.adminPanel.doctorAdmin.Entity.User;
import com.adminPanel.doctorAdmin.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveOneUser(User newUser) {
        User user = userRepository.save(newUser);
        return user;
    }

    public User getOneUser(Integer userId) {
        return userRepository.findById(userId).orElse(null);

    }

    public User updateOneUser(Integer userId, User newUser) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent())
        {
            User tempUser = user.get();
            tempUser.setName(newUser.getName());
            userRepository.save(tempUser);
            return tempUser;
        }
        else


            return null;
    }
}
