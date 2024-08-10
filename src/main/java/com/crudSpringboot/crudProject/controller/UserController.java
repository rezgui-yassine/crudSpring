package com.crudSpringboot.crudProject.controller;


import com.crudSpringboot.crudProject.dto.UserDto;
import com.crudSpringboot.crudProject.model.User;
import com.crudSpringboot.crudProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@ResponseBody
public class UserController {
    @Autowired
   private UserService userService;

    @GetMapping("/users")
    public List<User> displayStudents() {
        return userService.getAllUsers();
    }
    /*@GetMapping("/users")
    public ResponseEntity<List<User>> displayStudents() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }*/

    @GetMapping("/user/{id}")
    public UserDto displayUserById(@PathVariable Integer id) {
        return userService.getStudentById(id);
    }
    @PostMapping("/addUser")
    public UserDto addUser(@RequestBody User user) throws Exception {
        return userService.addUser(user);
    }

    @PutMapping("/updateUser")
    public UserDto updateUser(@RequestBody User user) throws Exception{
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) throws Exception {
        return userService.deleteUser(id);
    }
}
