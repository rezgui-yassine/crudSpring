package com.crudSpringboot.crudProject.controller;


import com.crudSpringboot.crudProject.model.User;
import com.crudSpringboot.crudProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
public class UserController {
    @Autowired
   private UserService userService;

    @GetMapping("/users")
    public List<User> displayStudents() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User displayUserById(@PathVariable Integer id) {
        return userService.getStudentById(id);
    }
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) throws Exception {
        return userService.addUser(user);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) throws Exception{
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
}
