package com.crudSpringboot.crudProject.repository;

import com.crudSpringboot.crudProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoUser extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);

}
