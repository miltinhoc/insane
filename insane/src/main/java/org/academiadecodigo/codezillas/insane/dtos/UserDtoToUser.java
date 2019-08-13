package org.academiadecodigo.codezillas.insane.dtos;

import org.academiadecodigo.codezillas.insane.persistence.model.User;
import org.academiadecodigo.codezillas.insane.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }



    public User user(UserDto userDto) {

        User user = (userDto.getId() != null ? userService.findById(userDto.getId()) : new User());

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setMainSkill(userDto.getMainSkill());
        user.setDisorder(userDto.getDisorder());
        user.setCountry(userDto.getCountry());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        user.setId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setSummary(userDto.getSummary());

        return user;
    }

}

