package com.example.springex.domain.dto;


import com.example.springex.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class UserDto {

    private int id;
    private String username;

    public static UserDto fromEntity(User user){
        return new UserDto(user.getId(),user.getUsername());
    }

}
