package com.adminPanel.doctorAdmin.Controller;

import com.adminPanel.doctorAdmin.Entity.User;
import com.adminPanel.doctorAdmin.ServiceLayer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }
    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.saveOneUser(newUser);

    }
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Integer userId){
        return userService.getOneUser(userId);
    }
    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Integer userId,@RequestBody User newUser){
        return userService.updateOneUser(userId,newUser);
    }
}
