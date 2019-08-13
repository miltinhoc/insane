package org.academiadecodigo.codezillas.insane.converters;

import org.academiadecodigo.codezillas.insane.dtos.UserDto;
import org.academiadecodigo.codezillas.insane.persistence.model.User;

public class UserDtoToUser {

    public User convert(UserDto userDto){
        User user = new User();

        user.setName(UserDto.getName());
        user.setId(UserDto.getId());
        user.setEmail(UserDto.getEmail());
        user.set

        return user;
    }
}
