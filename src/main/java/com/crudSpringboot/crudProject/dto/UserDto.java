package com.crudSpringboot.crudProject.dto;

import com.crudSpringboot.crudProject.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private String avatar;

    public static  UserDto fromEntity(User userEntity){
        return UserDto.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .avatar(userEntity.getAvatar())
                .build();

    }
}
