package com.crudSpringboot.crudProject.service;


import com.crudSpringboot.crudProject.dto.UserDto;
import com.crudSpringboot.crudProject.model.User;
import com.crudSpringboot.crudProject.repository.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private RepoUser repoUser;

    // create method for get all users
    public List<User> getAllUsers() {
        try {
            if (repoUser.findAll().isEmpty()) {
                return null;
            } else {
                return repoUser.findAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    public UserDto getStudentById(Integer id) {
        Optional<User> user = this.repoUser.findById(id);
        if (user.isPresent()){
            return UserDto.fromEntity(user.get());
        }
        else {
            return null;
        }
    }

    public UserDto addUser(User user) throws Exception {
        if (repoUser.existsByUsername(user.getUsername())) {
            throw new Exception("Username already exists");
        } else {
            return UserDto.fromEntity(repoUser.save(user));
        }
    }

    /*public User updateUser(User user) throws Exception {
       User user1 = new User();
       if (repoUser.existsById(user.getId())){
           user1.setId(user.getId());
           user1.setUsername(user.getUsername());
           user1.setEmail(user.getEmail());
           user1.setPassword(user.getPassword());
           user1.setAvatar(user.getAvatar());
           return repoUser.save(user);
    }
        return user1;
    }*/

    public UserDto updateUser(User user) throws Exception {
        User existingUser = repoUser.findById(user.getId())
                .orElseThrow(() -> new Exception("User not found with id: " + user.getId()));

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setAvatar(user.getAvatar());

        return UserDto.fromEntity((repoUser.save(existingUser)));
    }


    public ResponseEntity<String> deleteUser(Integer id) throws Exception {
        if (repoUser.existsById(id)) {
            repoUser.deleteById(id);
            return ResponseEntity.ok().body("User deleted successfully");

        } else {
            throw new Exception("User not found with id: " + id);
        }
    }

}
